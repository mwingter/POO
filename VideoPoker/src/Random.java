import java.util.Calendar;

//package random;


public class Random{
	private long p = 2147483648L;
	private long m = 844331461;
	private long a = 453816693;
	
	public long xi = 1023;
	

	public double GetRand(){
		
		xi = (a + m * xi) % p;
		double d = xi;
		
		return d/p;
	}
	
	//retorna valor entre 0 e max
	public int getIntRand(int max){
		
		double d = GetRand() * max;
		
		return (int) d;
	}
	
	//retorna o valor entre min e max
	public int getIntRand(int min, int max) throws IllegalArgumentException {
		if(max <= min){
			throw new IllegalArgumentException("Parâmetros inválidos");
		}
		return min + getIntRand(max - min);
	}
	
	//retorna um valor inteiro positivo qualquer, até o limite maximo
	public int getIntRand(){
		return getIntRand(Integer.MAX_VALUE);
	}
	
	@Override
	public String toString(){
			return xi + "";
	}
	
	public Random(int r){
			xi = r;
	}
	
	public Random(){
		try{
			Thread.sleep(1);
		} catch (InterruptedException e){
		}
		this.xi = Calendar.getInstance().getTimeInMillis() % p;
	}
	
	/*
	public static void main(String [] args) throws Exception{
		Random rd = new Random();
		System.out.println(rd);
		String s = "Instancia um objeto: " + rd;
		System.out.println(s);	
		int k = rd.getIntRand(100);
		System.out.println(rd);
		
		rand rd2 = new rand();
		System.out.println(rd);
		String t = "Instancia um objeto 2: " + rd2;
		System.out.println(t);
		int l = rd.getIntRand(100);
		System.out.println(rd2);
		

	}
	*/
}



