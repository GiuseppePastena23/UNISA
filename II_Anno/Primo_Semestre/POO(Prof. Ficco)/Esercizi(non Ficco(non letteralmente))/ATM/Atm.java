import java.util.ArrayList;
import java.util.Random;

public class Atm extends Banca {
    /**
     * Costanti per il testo dell'atm
     */
    private static final String BENVENUTO = "Benvenuto";
    private static final String ID_CLIENTE_INVALIDO = "Id Cliente invalido";
    private static final String SCELTA_ERRATA = "Scelta Errata";
    private static final String INSERIRE_CODICE_CLIENTE = "Inserire codice cliente...";
    private static final String INSERIRE_IL_PIN = "Inserire il pin...\n";
    private static final String CLIENTE_INESISTENTE = "Cliente inesistente";
    private static final String SELEZIONA_OPERAZIONE = "Seleziona l'operazione\n\t1.Saldo Conto Corrente\n\t2.Saldo Conto Risparmio\n\t3.Versa su Conto Corrente\n\t4.Versa Su Conto Risparmio\n\t5.Preleva da Conto Corrente\n\t6.Preleva da Conto Risparmio\n\t0. Exit";
    private static final String VERSAMENTO_CC = "Versamento su Conto Corrente\nQuanto vuoi versare?";
    private static final String PRELIEVO_CC = "Prelievo da Conto Corrente\nQuanto vuoi prelevare?";
    private static final String VERSAMENTO_CR = "Versamento su Conto Risparmio\nQuanto vuoi versare?";
    private static final String PRELIEVO_CR = "Prelievo da Conto Conto Risparmio\nQuanto vuoi prelevare?";
    private static final String PRELIEVO_EFFETTUATO = "Prelievo Effettuato";
    private static final String FONDI_INSUFFICIENTI = "Fondi Insufficienti";
    private static final String VERSAMENTO_EFFETTUATO = "Versamento Effettuato";

    private String display;
    private Cliente selectedCliente;
    private Conto selectedConto;
    private boolean versamento;
    private boolean prelievo;

    public Atm() {
        super();
        this.display = INSERIRE_CODICE_CLIENTE;
        this.selectedCliente = null;
    }

    public boolean clienteExists(int idCliente) {
        for (Cliente cliente : super.clienti) {
            if(cliente.getId() == idCliente){
                this.selectedCliente = cliente;
                return true;
            }
        }
        this.selectedCliente = null;
        return false;
    }

    @Override
    public String toString() {
        return this.display;
    }

	public void sendInput(String input) {
        //Siamo nel caso non e' ancora stato autenticato nessun cliente, l'input sara' l'idCLiente
        if(this.selectedCliente == null){
            displayLogin(input);
            return;
        } 
        
        if (!this.selectedCliente.isAuthenticated()) {
            displayInsertPin(input);
            return;
        } 
        
        if (this.selectedCliente.isAuthenticated()) {
            //Siamo nel caso in cui il cliente e' autenticato, l'input sara l'operazione da fare
            if(this.versamento){ 
                displayVersamento(input);
            } else if(this.prelievo){
                displayPrelievo(input);
                return;
            }
            displayChoice(input);
        }

	}

    private void displayChoice(String input) {
        try {
            int i = Integer.parseInt(input);
            if( i == 0 ){
                super.SaveFile();
                this.selectedCliente.logout();
                this.selectedCliente = null;
                this.display = String.format("%s", INSERIRE_CODICE_CLIENTE);
            } else if ( i == 1 ) {
                this.display = String.format("%s\n\n%s",
                        this.selectedCliente.getContoCorrente().toString(), SELEZIONA_OPERAZIONE);
            } else if ( i == 2 ) {
                this.display = String.format("%s\n\n%s",
                        this.selectedCliente.getContoRisparmio().toString(), SELEZIONA_OPERAZIONE);
            } else if ( i == 3 ) {
                this.versamento = true;
                this.selectedConto = this.selectedCliente.getContoCorrente();
                this.display = String.format("%s", VERSAMENTO_CC);
            } else if ( i == 4 ) {
                this.versamento = true;
                this.selectedConto = this.selectedCliente.getContoRisparmio();
                this.display = String.format("%s", VERSAMENTO_CR);
            } else if ( i == 5 ) {
                this.prelievo = true;
                this.selectedConto = this.selectedCliente.getContoCorrente();
                this.display = String.format("%s", PRELIEVO_CC);
            } else if ( i == 6 ) {
                this.prelievo = true;
                this.selectedConto = this.selectedCliente.getContoRisparmio();
                this.display = String.format("%s", PRELIEVO_CR);
            } else {
                this.display = String.format("%s\n%s",SCELTA_ERRATA, SELEZIONA_OPERAZIONE);
            }
        } catch (NumberFormatException e) {
            this.display = String.format("%s\n%s", SCELTA_ERRATA, SELEZIONA_OPERAZIONE);
        }
    }

    private void displayPrelievo(String input) {
        try {
            double i = Double.parseDouble(input);
            if (this.prelievo && this.selectedConto != null) {
                if (this.selectedConto.prelievo(i)) {
                    this.display = String.format("%s\n%s", PRELIEVO_EFFETTUATO, SELEZIONA_OPERAZIONE);
                    this.prelievo = false;
                    this.selectedConto = null;
                } else {
                    this.display = String.format("%s\n%s", FONDI_INSUFFICIENTI, SELEZIONA_OPERAZIONE);
                    this.prelievo = false;
                    this.selectedConto = null;
                }
            }
        } catch (NumberFormatException e) {
            this.display = String.format("%s\n%s", SCELTA_ERRATA, SELEZIONA_OPERAZIONE);
        }
    }

    private void displayVersamento(String input) {
        try {
            double i = Double.parseDouble(input);
            if (this.versamento && this.selectedConto != null) {
                this.selectedConto.versa(i);
                this.versamento = false;
                this.selectedConto = null;
                this.display = String.format("%s\n%s", VERSAMENTO_EFFETTUATO, SELEZIONA_OPERAZIONE);
            }
        } catch (NumberFormatException e) {
            this.display = String.format("%s\n%s", SCELTA_ERRATA, SELEZIONA_OPERAZIONE);
        }
    }

    private void displayInsertPin(String input) {
        //Siamo nel caso in cui il cliente non e' autenticato, l'input sara il pin
        if(this.selectedCliente.login(input)) {
            this.display = String.format("%s\n%s",BENVENUTO,SELEZIONA_OPERAZIONE);
        } else {
            this.display = String.format("%s",INSERIRE_CODICE_CLIENTE);
            this.selectedCliente = null;
        }
    }

    private void displayLogin(String input) {
        try {
            int id =Integer.parseInt(input);
            if( clienteExists(id) ){
                this.display = INSERIRE_IL_PIN;
            } else {
                this.display = String.format("%s\n%s",CLIENTE_INESISTENTE, INSERIRE_CODICE_CLIENTE);
            }
        } catch (NumberFormatException e) {
            this.display = String.format("%s\n%s", ID_CLIENTE_INVALIDO, INSERIRE_CODICE_CLIENTE);
        }
    }
}
