package kut.compiler.parser.ast;

import java.io.IOException;

import kut.compiler.compiler.CodeGenerator;
import kut.compiler.exception.CompileErrorException;
import kut.compiler.lexer.Token;

public class AstPrint extends AstNode 
{
	/**
	 * 
	 */
	protected Token t;
	
	protected AstNode	expr;
	
	/**
	 * @param t
	 */
	public AstPrint(AstNode expr, Token t)
	{
		this.expr 	= expr;
		this.t 		= t;
	}
	
	
	/**
	 * @param gen
	 */
	public void preprocessStringLiterals(CodeGenerator gen) {
		expr.preprocessStringLiterals(gen);
	}

	/**
	 *
	 */
	@Override
	protected void printTree(int indent) {
		this.println(indent, "print : ");
		expr.printTree(indent + 1);
	}



	/**
	 *
	 */
	@Override
	public void cgen(CodeGenerator gen) throws IOException, CompileErrorException
	{	
		this.expr.cgen(gen);
		gen.printCode("call " + gen.getPrintIntLabel());
		return; 
	}
	

	/**
	 *
	 */
	/**
	 *
	 */
	public void preprocessGlobalVariables(CodeGenerator gen)
	{
		return;
	}
	
}
