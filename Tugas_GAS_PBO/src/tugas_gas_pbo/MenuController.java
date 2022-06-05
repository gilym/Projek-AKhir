
package tugas_gas_pbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    MenuView mv;
    

    public MenuController(MenuView menuView) {
        this.mv = menuView;
        

        // lihat data ==========================================================
        menuView.btnBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                     BukuView bukuview =new BukuView();
                     BukuModel bukumodel = new BukuModel();
                     new BukuController(bukumodel,bukuview);
                     mv.dispose();
            }
        });
        
          menuView.btnAnggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                     AnggotaView av =new AnggotaView();
                     AnggotaModel am= new AnggotaModel();
                    new AnggotaController (am,av);
                     mv.dispose();
            }
        });
          
                    menuView.btnPeminjaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    PinjamView pv = new PinjamView();
                    PinjamModel pm= new PinjamModel();
                    new PinjamController(pv,pm);
                     mv.dispose();
            }
        });
    }

}
