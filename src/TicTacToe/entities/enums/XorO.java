package TicTacToe.entities.enums;


public enum XorO {
		
	X("X"),
	O("O"),
	TYPE_BLANK("  ");
	
	public String descricao;

	XorO(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
