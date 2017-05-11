package epam.javatr.login.command;

public enum CommandEnum {
	LOGIN {
		{
			this.command=new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command=new LogoutCommand();
		}
	},
	REGISTER {
		{
		this.command = new RegisterCommand();
		}
	},
	RECALL {
		{
		this.command=new RecallCommand();
		}
	};
	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
