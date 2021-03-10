package projects;

public class BankingMain {

	public static void main(String[] args) throws InterruptedException {

		SiteBase site = new SiteBase();
		site.url();
		site.signup();
		site.login();
		site.newCustomer();
		site.editCustomer();
		site.deleteCustomer();
		site.close();
	}
}
