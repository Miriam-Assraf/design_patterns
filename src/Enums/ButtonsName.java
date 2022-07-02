package Enums;

public enum ButtonsName {
	LOADTOSHIP("Load to ship"),
	LOADFROMSHIP("Load from ship"),
	LOADFROMTRUCK("Load from truck"),
	LOADTOTRUCK("Load to truck");
	//UNDO("Undo"),
	//REDO("Redo");
	
	 private final String text;
	 ButtonsName(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
