/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.yabi.SqlQuery;

/**
 *
 * @author hydrocat
 */
public class SqlQueryViewModel {
    
    public Long id;
    public String command; //Deve existir ?
    public String name;
    public String description;
    public long directory;
    public String permission;
    
    public SqlQueryViewModel( SqlQuery q ) {
        id = q.getId();
        command = q.getCommand();
        name = q.getName();
        description = q.getDescription();
        directory = q.getDirectory().getId();
        permission = q.getPermission().getNodePath();
    }
}
