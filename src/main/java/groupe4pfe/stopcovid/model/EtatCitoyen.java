package groupe4pfe.stopcovid.model;

public enum EtatCitoyen {
  MALADE("Malade"),
  POTENTIELLEMENT_MALADE("Potentiellement malade"),
  EN_BONNE_SANTE("Sain");

  private String etat;


  EtatCitoyen(String etat) {
    this.etat = etat;
  }

  public String getEtat() {
    return etat;
  }

  @Override
  public String toString() {
    return etat;
  }
}
