package epam.javatr.parser.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import epam.javatr.parser.parsing.DOMParser;
import epam.javatr.parser.parsing.FlowersBuilder;
import epam.javatr.parser.parsing.SAXParser;
import epam.javatr.parser.parsing.StAXParser;
import epam.javatr.parser.validation.FlowerValidation;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

@WebServlet("/timeaction")

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100) // 100 MB

public class ParserServlet extends HttpServlet {

	private static final long serialVersionUID = 205242440643911308L;;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}


	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("menu").equals("parser")){
			String fName = request.getParameter("Parser");
			String uploadFilePath = this.getServletContext().getRealPath("\\") + "\\uploads\\flowers.xml";
			request.getPart("fileName").write(uploadFilePath);
			FlowersBuilder builder = null;
			switch (fName) {
			case "DOM":
				builder = new DOMParser();
				break;
			case "SAX":
				builder = new SAXParser();
				break;
			case "StAX":
				builder = new StAXParser();
				break;
			}
			builder.buildSetFlowers(uploadFilePath);
			request.setAttribute("flowers", builder.getFlowers());
			request.getRequestDispatcher("/jsp/result.jsp").forward(request, response);
		} else {
			String uploadFilePathXML = this.getServletContext().getRealPath("\\") + "\\uploads\\flowers.xml";
			request.getPart("fileXML").write(uploadFilePathXML);
			String uploadFilePathXSD = this.getServletContext().getRealPath("\\") + "\\uploads\\flowers.xsd";
			request.getPart("fileXSD").write(uploadFilePathXSD);
			FlowerValidation validation = new FlowerValidation();
			validation.validateSchema(request, uploadFilePathXML, uploadFilePathXSD);
			String page = "/jsp/validation.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			dispatcher.forward(request, response);
		}
		
	}
}
