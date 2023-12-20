public class Imballaggio {
        protected int dimensione;
        protected int peso;

        public Imballaggio(int dimensione, int peso) {
            this.dimensione = dimensione;
            this.peso = peso;
        }

        public int getDimensione() {
            return dimensione;
        }

        public void setDimensione(int dimensione) {
            this.dimensione = dimensione;
        }

        public int getPeso() {
            return peso;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }
}
