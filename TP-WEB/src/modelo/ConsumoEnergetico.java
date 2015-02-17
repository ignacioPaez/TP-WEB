package modelo;

public class ConsumoEnergetico {

	char consumoEner;
	double precio;

	public char getConsumoEner() {
		return consumoEner;

	}

	public double getPrecio() {
		this.setPrecio(consumoEner);
		return precio;
	}

	public void setPrecio(char consumoEnergetico) {
		switch (consumoEnergetico) {
		case 'A':
			this.precio = 100;
			break;
		case 'B':
			this.precio = 80;
			break;
		case 'C':
			this.precio = 60;
			break;
		case 'D':
			this.precio = 50;
			break;
		case 'E':
			this.precio = 30;
			break;
		case 'F':
			this.precio = 10;
			break;

		}

	}

	public void setConsumoEner(char consumoEner) {
		this.consumoEner = consumoEner;
	}

}
