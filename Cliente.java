import java.io.*;
import java.util.*;

class Cliente 
{
	private String nome;
	private String email;

	List<Conta> Contas;

	Cliente(String nome, String email) 
	{
		this.Contas = new ArrayList<Conta>();
		this.nome = nome;
		this.email = email;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public void IncluirConta(Conta Conta) 
	{
		Contas.add(Conta);
	}

	public double GetSaldoGeral() 
	{
		double saldo = 0;
		Iterator it = Contas.iterator();
		while (it.hasNext()) 
		{
			Conta c = (Conta) it.next();
			saldo += c.getSaldo();
		}
		return saldo;
	}
}