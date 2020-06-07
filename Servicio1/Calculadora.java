
public class Calculadora{
	public float sumar (float s1, float s2){
		return s1 + s2;
	}
	public float restar (float min, float sus){
		return min - sus;
	}
	public float multiplicar (float m1, float m2){
		return (float)m1 * (float)m2;
	}
	public float dividir (float num, float dem){
		if (num==0 || dem == 0){
			return (float)0;
		}
		else {
			return (float)num/(float)dem;
		}
	}
}

