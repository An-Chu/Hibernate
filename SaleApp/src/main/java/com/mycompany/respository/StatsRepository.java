/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.respository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public interface StatsRepository {
    public List<Object[]> statsByCategory();
    public List<Object[]> statsByTopSell();
    public List<Object[]> statsRevenue(Date fromDate, Date toDate);
}
