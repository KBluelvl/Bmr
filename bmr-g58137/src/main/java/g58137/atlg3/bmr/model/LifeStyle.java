package g58137.atlg3.bmr.model;

/**
 * enum of lifestyle.
 * @author  Florian Essomba
 */
public enum LifeStyle {
    SEDENTAIRE("Sédentaire",1.2),
    PEU_ACTIF("Peu actif",1.375),
    ACTIF("Actif",1.55) ,
    FORT_ACTIF("Fort actif",1.725),
    EXTREMEMENT_ACTIF("Extrêmement actif",1.9);

    private final String style;
    private final double value;

    LifeStyle(String style, double value) {
        this.style = style;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getStyle() {
        return style;
    }
}
