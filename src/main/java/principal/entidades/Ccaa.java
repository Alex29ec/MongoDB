package principal.entidades;

public class Ccaa {
	String code,parent_code,label;

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return  label;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParent_code() {
		return parent_code;
	}

	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
