abstract class Conta 
{
	public Double Saldo;

	public abstract Double getSaldo();

	public void deposita(Double Saldo) 
	{
		this.Saldo = Saldo;
	}
}