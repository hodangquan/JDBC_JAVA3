/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.SQLException;
import java.util.List;
import model.Iventory;
import repository.GheRepository;
import repository.IventoryLogRepository;

/**
 *
 * @author hodangquan
 */
public class IventoryLogService {
    IventoryLogRepository inIventoryLogRepository;
    GheRepository gheRepository;
    
    public IventoryLogService(){
        inIventoryLogRepository = new IventoryLogRepository();
        gheRepository = new GheRepository();
    }
    public List<Iventory> layDSBaoCao(String date) throws SQLException{
        return inIventoryLogRepository.layDSBaoCao( date);
    }
    public boolean themBaoCao(Integer ProductId , String IEDate , Integer SoLuongXuat ) throws SQLException{
        return inIventoryLogRepository.themBaoCao(ProductId, IEDate, SoLuongXuat);
    }
}
