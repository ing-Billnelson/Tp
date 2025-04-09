package Vole;

public class Object {

        private String type;
        private String numeroSerie;
        private String marque;
        private boolean vole;

        public Object(String type, String numeroSerie, String marque, boolean vole) {
            this.type = type;
            this.numeroSerie = numeroSerie;
            this.marque = marque;
            this.vole = vole;
        }

        // Getters et setters
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getNumeroSerie() { return numeroSerie; }
        public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }

        public String getMarque() { return marque; }
        public void setMarque(String marque) { this.marque = marque; }

        public boolean isVole() { return vole; }
        public void setVole(boolean vole) { this.vole = vole; }
    }

