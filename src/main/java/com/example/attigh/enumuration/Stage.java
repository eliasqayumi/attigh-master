package com.example.attigh.enumuration;

public enum Stage {
    PLANLAMA("PLANLAMA"),
    ETUT_PROJE("ETÜT/PROJE"),
    UYGULAMA_INSAAT("UYGULAMA (İNŞAAT)"),
    TESCIL_ISLETME("TESCİL (İŞLETME)");

    String stagePlan;

    Stage(String stagePlan) {
        this.stagePlan = stagePlan;
    }

    public String getStage() {
        return stagePlan;
    }
}
