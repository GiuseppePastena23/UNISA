package Progetto.ClassiQuery;

public class Scuderia 
{

        private String nome;
        private String sedeCentrale;
    
        public Scuderia(String nome, String sedeCentrale) {
            this.nome = nome;
            this.sedeCentrale = sedeCentrale;
        }
    
        public String getNome() {
            return nome;
        }
    
        public void setNome(String nome) {
            this.nome = nome;
        }
    
        public String getSedeCentrale() {
            return sedeCentrale;
        }
    
        public void setSedeCentrale(String sedeCentrale) {
            this.sedeCentrale = sedeCentrale;
        }
    
        @Override
        public String toString() {
            return "Scuderia{" +
                    "nome='" + nome + '\'' +
                    ", sedeCentrale='" + sedeCentrale + '\'' +
                    '}';
        }
}
