import java.io.*;
import java.util.*;

class Principal 
{
	public static void main(String[] args) 
	{
		InputStreamReader ISRin = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ISRin);

		try 
		{
			List<Cliente> cliente = new ArrayList<Cliente>();
			String terminar = "0";
			while (!terminar.equals("5")) 
			{
				System.out.println("Digite a operacao que deseja");
				System.out.println("1 - Cadastrar Cliente");
				System.out.println("2 - Criar Conta");
				System.out.println("3 - Ver Saldo Geral");
				System.out.println("4 - Saldo Geral de Todos os Clientes");
				System.out.println("5 - Sair");
				terminar = in.readLine();
				if (terminar.equals("1")) 
				{
					System.out.println("Informe o nome e o email");
					cliente.add(new Cliente(in.readLine(), in.readLine()));
				}
				if (terminar.equals("2")) 
				{
					int id = 0;
					if(cliente.size() != 0)
					{

						System.out.println("Selecione o usuario");
						for (int i = 0; i < cliente.size(); i++) 
						{
							System.out.println(i + " - " + cliente.get(i).getNome());
						}
						id = Integer.parseInt(in.readLine());
						System.out.println("Selecione o tipo");
						System.out.println("1 - Corrente");
						System.out.println("2 - Poupanca");
						int idTipo = Integer.parseInt(in.readLine());
						System.out.println("Informe o Saldo");
						double saldo = Double.parseDouble(in.readLine());
						double limite = 0;
						double cpmf = 0;
						Conta conta;
						if (idTipo == 1) 
						{
							System.out.println("Informe o limite");
							limite = Double.parseDouble(in.readLine());
							cpmf = saldo * 0.0038;
							conta = new ContaCorrente(limite, cpmf);
						} else 
						{
							conta = new ContaPoupanca();
						}
						conta.deposita(saldo);
						cliente.get(id).IncluirConta(conta);
					}
					else
					{
						System.out.println("Nenhum Cliente Cadastrado!");
					}
				}
				if (terminar.equals("3")) 
				{
					int id = 0;					
					if(cliente.size() != 0)
					{
						System.out.println("Selecione o Cliente:");
						for (int i = 0; i < cliente.size(); i++) 
						{
							System.out.println(i + " - " + cliente.get(i).getNome());
						}
						id = Integer.parseInt(in.readLine());
						System.out.println("Saldo Geral do Usuario: " + cliente.get(id).GetSaldoGeral());						
					}
					else
					{
						System.out.println("Nenhum Cliente Cadastrado!");
					}					
				}
				if (terminar.equals("4")) 
				{
					if(cliente.size() == 0)
					{
						System.out.println("Nenhum Cliente Cadastrado!");
					}
					for (int i = 0; i < cliente.size(); i++) 
					{						
						System.out.println("Usuario:" + cliente.get(i).getNome());
						System.out.println("Saldo Geral: " + cliente.get(i).GetSaldoGeral());
					}
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}