/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer
 */
public class BlackJackTest {
    
    public BlackJackTest() {
    }

    /**
     * Test of checkBust method, of class BlackJack.
     */
    @Test
    public void testCheckBustGood() {
        System.out.println("checkBustGood");
        int handvalue = 22;
        boolean expResult = true;
        boolean result = BlackJack.checkBust(handvalue);
        assertEquals(expResult, result);
    }
@Test
    public void testCheckBustBad() {
        System.out.println("checkBustBad");
        int handvalue = 20;
        boolean expResult = false;
        boolean result = BlackJack.checkBust(handvalue);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckBustBoundry() {
        System.out.println("checkBustBoundry");
        int handvalue = 21;
        boolean expResult = false;
        boolean result = BlackJack.checkBust(handvalue);
        assertEquals(expResult, result);
    }
    
}
