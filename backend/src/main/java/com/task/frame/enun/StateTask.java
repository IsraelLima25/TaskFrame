package com.task.frame.enun;

public enum StateTask {
	
	DELIVERED(1, "Delivered"), PENDING(2, "Pending");
	
	private Integer codigo;
	private String descricao;

	private StateTask(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
