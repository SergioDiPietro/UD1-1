public class Alumno {

    // Atributos
    private String nombre;
    private float nota1;
    private float nota2;
    private float nota3;
    private float nota4;
    private float media;

    // Constructores
    public Alumno() {
        this.nombre = "";
        this.nota1 = 0;
        this.nota2 = 0;
        this.nota3 = 0;
        this.nota4 = 0;
        this.media = 0;
    }
    public Alumno(String nombre) {
        this.nombre = nombre;
        this.nota1 = (float)Math.random()*10;
        this.nota1 = (float)Math.random()*10;
        this.nota1 = (float)Math.random()*10;
        this.nota1 = (float)Math.random()*10;
        this.media = (nota1+nota2+nota3+nota4)/4;
    }
}
