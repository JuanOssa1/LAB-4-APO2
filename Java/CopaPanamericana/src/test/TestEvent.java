package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Event;

public class TestEvent {
	private Event event;
	
	private void setUpSceneInsert() { 
		event = new Event();
		event.insertViewver("1", "Juan", "Forero", "cpa@hotmail.com", "Masculino", "Colombia", "www.lenovo.com", "12/12/2021");
		event.insertViewver("0", "Juan", "Forero", "cpa@hotmail.com", "Masculino", "Colombia", "www.lenovo.com", "12/12/2021");
		event.insertViewver("4", "Juan", "Forero", "cpa@hotmail.com", "Masculino", "Colombia", "www.lenovo.com", "12/12/2021");
	}
	@Test
	public void testInsert() {
		setUpSceneInsert();
		String info = event.getOrigin().toString();
		assertEquals("1,Juan,Forero,cpa@hotmail.com,Masculino,12/12/2021,Colombia,www.lenovo.com,12/12/2021", info);
	}
	@Test
	public void testInsertLeft() {
		setUpSceneInsert();
		String info = event.getOrigin().getLeft().toString();
		assertEquals("0,Juan,Forero,cpa@hotmail.com,Masculino,12/12/2021,Colombia,www.lenovo.com,12/12/2021", info);
	}
	@Test
	public void testRight() {
		setUpSceneInsert();
		String info = event.getOrigin().getRight().toString();
		assertEquals("4,Juan,Forero,cpa@hotmail.com,Masculino,12/12/2021,Colombia,www.lenovo.com,12/12/2021", info);
	}
	private void setUpSceneSearchViewverWithId() {
		event = new Event();
		event.insertViewver("1", "Juan", "Forero", "cpa@hotmail.com", "Masculino", "Colombia", "www.lenovo.com", "12/12/2021");
		event.insertViewver("12", "Kar", "Ossaaaaa", "cpffa@hotmail.com", "Masculino", "Colombia", "www.lenovo.com", "12/12/2201");
		event.insertViewver("0", "li", "Restre", "cpqwea@hotmail.com", "Masculino", "Colombia", "www.lenovo.com", "12/12/2006");
		event.insertViewver("1234", "kim", "el mejor", "cghhjpa@hotmail.com", "Masculino", "Colombia", "www.lenovo.com", "12/12/2009");
		event.insertViewver("4", "jum", "Otero", "cpaaa@hotmail.com", "Masculino", "Colombia", "www.lenovo.com", "12/12/2001");
	}
	@Test
	public void testSceneSearchViewverWithIdBegginig() {
		setUpSceneSearchViewverWithId();
		String beginnig = event.searchViewverWithId("1").toString();
		assertEquals("1,Juan,Forero,cpa@hotmail.com,Masculino,12/12/2021,Colombia,www.lenovo.com,12/12/2021", beginnig);
		
	}
	@Test
	public void testSceneSearchViewverWithIdMedium() {
		setUpSceneSearchViewverWithId();
		String medium = event.searchViewverWithId("0").toString();
		assertEquals("0,li,Restre,cpqwea@hotmail.com,Masculino,12/12/2006,Colombia,www.lenovo.com,12/12/2006", medium);
	}
	@Test
	public void testSceneSearchViewverWithIdFinal() {
		setUpSceneSearchViewverWithId();
		String finall = event.searchViewverWithId("4").toString();
		assertEquals("4,jum,Otero,cpaaa@hotmail.com,Masculino,12/12/2001,Colombia,www.lenovo.com,12/12/2001", finall);
	}
	@Test
	public void testShowViewvers() {
		setUpSceneSearchViewverWithId();
		String show = event.printlViewvers();
		assertEquals(show, 1);
	}

}
