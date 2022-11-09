class ContaCorrente extends Conta 
{
	public Double Limite;
	public Double cpmf;

	ContaCorrente(Double Limite, Double cpmf) 
	{
		this.Limite = Limite;
		this.cpmf = cpmf;
	}

	public Double getSaldo() 
	{
		return (Saldo - cpmf + Limite);
	}
}