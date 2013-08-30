package com.p4.upload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
    
    @RequestMapping(value="upload/upload-gambar", method= RequestMethod.GET)
    public void tampilForm(){
        System.out.println("menampilkan form");
    }
    
    @RequestMapping(value="upload/upload-gambar", method= RequestMethod.POST)
    public String prosesForm(@RequestParam("photofile") MultipartFile fileUpload )throws Exception{
        String namaFile = fileUpload.getOriginalFilename();
        
        File file = new File("src/main/webapp/upload-folder/"+namaFile);
        fileUpload.transferTo(file);
        return "redirect:/aplikasi/upload/uploaded-file";
    }
    
    @RequestMapping("upload/uploaded-file")
    public ModelMap tampilFile(){
        List<FileUpload> lFile = new ArrayList<FileUpload>();
        String direktori="src/main/webapp/upload-folder/";        
        File folder=new File(direktori);
        File[] lisGambar = folder.listFiles();
        for (File file : lisGambar){
            if(file.isFile()){
                FileUpload ofu = new FileUpload();
                ofu.setNamaFile(file.getName());
                ofu.setUkuranFile(file.length()/1024);
                lFile.add(ofu);
            }
        }
        ModelMap mm = new ModelMap();
        mm.addAttribute("listFile", lFile);
        return mm;
    }
    
    @RequestMapping("upload/hapus-file")
    public String hapusFile(@RequestParam("namaFile") String namaFile){
        File file = new File("src/main/webapp/upload-folder/"+namaFile);
        boolean hapus = file.delete();
        if(hapus){
            System.out.println("hapus berhasil");
        }else{
            System.out.println("hapus gagal");
        }
        
        return "redirect:uploaded-file";
    }
    
    @RequestMapping("upload/hapus-semua-file")
    public String hapusSemuaFile(){
        String direktori="src/main/webapp/upload-folder/";        
        File folder=new File(direktori);
        File[] lisGambar = folder.listFiles();
        for (File file : lisGambar){
            if(file.isFile()){                
                File namaFile = new File(file.getName());
                boolean hapus = file.delete();
            }
        }
        
        return "redirect:uploaded-file";
    }
    
    @RequestMapping(value="upload/hapus-semua-file",method= RequestMethod.POST)
    public String hapusPilihanFile(@RequestParam("filePilihan") String[] filePilihan){
        if(filePilihan==null){
            return "redirect:uploaded-file";
        }
        
        for (String nama : filePilihan) {
          File nameFile  = new File("src/main/webapp/upload-folder/"+nama);
          Boolean hapus = nameFile.delete();
        }
        return "redirect:uploaded-file";
    }
}
