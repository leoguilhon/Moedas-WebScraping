import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automacao {

	@Test
	public void pegarcotacoes() {
		System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver();
		// Cotação do Dólar
		navegador.get("https://google.com");
		navegador.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).click();
		navegador.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("cotacao dolar", Keys.ENTER);
		String cotacaodolar = navegador.findElement(By.xpath("//*[@id=\"knowledge-currency__updatable-data-column\"]/div[1]/div[2]/span[1]")).getAttribute("data-value");
		float dolar = Float.parseFloat(cotacaodolar);
		System.out.printf("Dólar atual: R$ %.2f %n", dolar);
		// Cotação do Euro
		navegador.get("https://google.com");
		navegador.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).click();
		navegador.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input")).sendKeys("cotacao euro", Keys.ENTER);
		String cotacaoeuro = navegador.findElement(By.xpath("//*[@id=\"knowledge-currency__updatable-data-column\"]/div[1]/div[2]/span[1]")).getAttribute("data-value");
		float euro = Float.parseFloat(cotacaoeuro);
		System.out.printf("Euro atual: R$ %.2f %n", euro);
		// Cotação do Ouro
		navegador.get("https://www.melhorcambio.com/ouro-hoje");
		String cotacaoouro = navegador.findElement(By.xpath("//*[@id=\"comercial\"]")).getAttribute("value");
		cotacaoouro = cotacaoouro.replace(",", ".");
		float ouro = Float.parseFloat(cotacaoouro);
		System.out.printf("Ouro atual: R$ %.2f %n", ouro);

		navegador.quit();
	}
}
