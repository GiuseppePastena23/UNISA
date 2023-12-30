

public class Cliente {
	String nome;
	int id;
	String pin;
	boolean loggedIn;
	ContoRisparmio contoRisparmio;
	ContoCorrente contoCorrente;

	public Cliente(String nome, int idCliente, String pin, ContoRisparmio contoRisparmio, ContoCorrente contoCorrente) {
		this.nome = nome;
		this.id = idCliente;
		this.pin = pin;
		this.loggedIn = false;
		this.contoCorrente = contoCorrente;
		this.contoRisparmio = contoRisparmio;
	}

	public Cliente(int idCliente) {
		this.id = idCliente;
	}

	public boolean login(String p) {
		this.loggedIn = this.pin.equals(p);
		return isAuthenticated();
	}

	@Override
	public boolean equals(Object o) {
		// Se e' lo stesso oggetto ritorna true
		if (o == this) {
			return true;
		}
		/*
		 * Se e' un istanza di Cliente o non "null instanceof [type]"
		 * returns false
		 */
		if (!(o instanceof Cliente)) {
			return false;
		}
		// typecast a CLiente in modo da poter comparare gli id
		Cliente c = (Cliente) o;
		return id == c.id;
	}

	public boolean isAuthenticated() {
		return this.loggedIn;
	}

	public Object getSaldoContoCorrente() {
		return this.contoCorrente.getSaldo();
	}

	public Object getSaldoContoRisparmio() {
		return this.contoRisparmio.getSaldo();
	}

	public int getId() {
		return this.id;
	}

	public String getPin() {
		return this.pin;
	}

	public String getNome() {
		return this.nome;
	}

}
