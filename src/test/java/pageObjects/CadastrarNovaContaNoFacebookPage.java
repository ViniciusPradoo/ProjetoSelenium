package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastrarNovaContaNoFacebookPage {
	
	WebDriver driver;
	
	public CadastrarNovaContaNoFacebookPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public CadastrarNovaContaNoFacebookPage criarConta(String nome, String sobrenome, String email, String senha, String nascimento, String genero) {
		
		preencheNome(nome);
		preencheSobrenome(sobrenome);
		preencheEmail(email);
		preencheSenha(senha);
		preencheNascimento(nascimento);
		preencheGenero(genero);
		clicarConfirmar();
		
		return this;
		
	}
	
	
	public CadastrarNovaContaNoFacebookPage preencheNome(String nome) {
		
		driver.findElement(By.name("firstname")).sendKeys(nome);
		return this;
		
	}
	
	public CadastrarNovaContaNoFacebookPage preencheSobrenome(String sobrenome) {
		
		driver.findElement(By.name("lastname")).sendKeys(sobrenome);		
		return this;
		
	}

	public CadastrarNovaContaNoFacebookPage preencheEmail(String email) {
		
		driver.findElement(By.name("reg_email__")).sendKeys(email);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);
		return this;
	}
	
	public CadastrarNovaContaNoFacebookPage preencheSenha(String senha) {
		
		driver.findElement(By.name("reg_passwd__")).sendKeys(senha);
		return this;
	}
	
	public CadastrarNovaContaNoFacebookPage preencheNascimento(String nascimento) {
		
		String[] data = nascimento.split("/");
				
		String dataDia = data[0];
		String dataMes = data[1];		
		String dataAno = data[2];
		
		switch (dataMes) {
		
		case "1":
			dataMes = "Jan";	
		break;
		case "2":
			dataMes = "Fev";
			break;
		case "3":
			dataMes = "Mar";
			break;
		case "4":
			dataMes = "Abr";
			break;
		case "5":
			dataMes = "Mai";
			break;
		case "6":
			dataMes = "Jun";
			break;
		case "7":
			dataMes = "Jul";
			break;
		case "8":
			dataMes = "Ago";
			break;
		case "9":
			dataMes = "Set";
			break;
		case "10":
			dataMes = "Out";
			break;
		case "11":
			dataMes = "Nov";
			break;
		case "12":
			dataMes = "Dez";
			break;
		}
		
		WebElement comboDia = driver.findElement(By.id("day"));
		Select select = new Select(comboDia);
		select.selectByVisibleText(dataDia);
				
		
		WebElement comboMes = driver.findElement(By.id("month"));
		select = new Select(comboMes);
		select.selectByVisibleText(dataMes);
		
		WebElement comboAno = driver.findElement(By.id("year"));
		select = new Select(comboAno);
		select.selectByVisibleText(dataAno);
			
		return this;
	}
	
	public CadastrarNovaContaNoFacebookPage preencheGenero(String genero) {
		
		switch (genero) {
		
		case "Feminino":
			genero = "u_0_6";	
		break;
		case "Masculino":
			genero = "u_0_7";
			break;
		case "Personalizado":
			genero = "u_0_8";
			break;
		}
		
		driver.findElement(By.id(genero)).click();
		
		return this;
	}
	
	public CadastrarNovaContaNoFacebookPage clicarConfirmar() {
		
		driver.findElement(By.name("websubmit")).click();
		
		return this;
	}	
	
	
}
