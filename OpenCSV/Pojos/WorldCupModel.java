package Pojos;

public class WorldCupModel {

	private String years;
	private String winnerCountryName;
	private String looserCountryName;
	private String winningDetails;

	public WorldCupModel() {

	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public WorldCupModel(String years, String winnerCountryName, String looserCountryName, String winningDetails) {
		this.years = years;
		this.winnerCountryName = winnerCountryName;
		this.looserCountryName = looserCountryName;
		this.winningDetails = winningDetails;
	}



	public String getWinnerCountryName() {
		return winnerCountryName;
	}

	public void setWinnerCountryName(String winnerCountryName) {
		this.winnerCountryName = winnerCountryName;
	}

	public String getLooserCountryName() {
		return looserCountryName;
	}

	public void setLooserCountryName(String looserCountryName) {
		this.looserCountryName = looserCountryName;
	}

	public String getWinningDetails() {
		return winningDetails;
	}

	public void setWinningDetails(String winningDetails) {
		this.winningDetails = winningDetails;
	}
}
