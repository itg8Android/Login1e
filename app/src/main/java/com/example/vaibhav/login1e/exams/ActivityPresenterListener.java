package com.example.vaibhav.login1e.exams;

import com.example.vaibhav.login1e.dashboard.model.Jobrole;
import com.example.vaibhav.login1e.dashboard.model.SectorSsc;

import java.util.List;

/**
 * Created by swapnilmeshram on 12/03/17.
 */

interface ActivityPresenterListener {
    void showSscSector(List<SectorSsc> list);
    void showJobrole(List<Jobrole> list);
}
