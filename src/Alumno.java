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
        this.nota2 = (float)Math.random()*10;
        this.nota3 = (float)Math.random()*10;
        this.nota4 = (float)Math.random()*10;
        this.media = (nota1+nota2+nota3+nota4)/4;
    }

    // Getters & Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public float getNota4() {
        return nota4;
    }

    public void setNota4(float nota4) {
        this.nota4 = nota4;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }
}
