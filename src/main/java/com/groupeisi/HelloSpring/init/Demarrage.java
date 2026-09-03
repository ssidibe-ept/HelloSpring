package com.groupeisi.HelloSpring.init;

import com.groupeisi.HelloSpring.entities.Etudiant;
import com.groupeisi.HelloSpring.repositories.EtudiantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class Demarrage implements CommandLineRunner {


    private final EtudiantRepository etudiantRepository;


    // 100 prénoms africains : 80 sénégalais + 20 autres africains
    private String[] prenomsAfricains = {
            // 80 prénoms sénégalais
            "Amadou", "Mamadou", "Ibrahima", "Ousmane", "Cheikh",
            "Abdoulaye", "Modou", "Babacar", "Pape", "Serigne",
            "Moussa", "Samba", "Lamine", "Boubacar", "Alioune",
            "Malick", "Mansour", "Souleymane", "Daouda", "Tidiane",
            "Thierno", "Saliou", "Assane", "Abdou", "Matar",
            "Mor", "El Hadji", "Massamba", "Demba", "Balla",
            "Youssoupha", "Birame", "Makhtar", "Cheikhouna", "Ibra",
            "Fatou", "Awa", "Mariama", "Astou", "Aminata",
            "Mame", "Khady", "Ndeye", "Sokhna", "Rama",
            "Coumba", "Adama", "Bineta", "Diary", "Anta",
            "Rokhaya", "Ndèye", "Seynabou", "Sokhna", "Maguette",
            "Dieynaba", "Nabou", "Fama", "Mame Diarra", "Mame Fatou",
            "Mame Awa", "Mame Khady", "Mame Astou", "Mame Coumba",
            "Mame Mariama", "Mame Aminata", "Mame Sokhna", "Mame Anta",
            "Mame Bineta", "Mame Seynabou", "Aïssatou", "Binta",
            "Kiné", "Nafi", "Yacine", "Fari", "Sokhna",
            "Ndèye Fatou", "Ndèye Awa", "Ndèye Astou",

            // 20 autres prénoms africains
            "Kwame", "Kofi", "Chinua", "Chinedu", "Ngozi",
            "Amara", "Zuberi", "Jelani", "Amani", "Baraka",
            "Nia", "Zuri", "Thabo", "Lerato", "Sipho",
            "Nomsa", "Tendai", "Tariro", "Chipo", "Mpho"
    };

    // 50 noms de famille africains : 40 sénégalais + 10 autres africains
    String[] nomsFamilleAfricains = {
            // 40 noms de famille sénégalais
            "Diop", "Ndiaye", "Fall", "Sow", "Ba",
            "Diallo", "Gueye", "Faye", "Sarr", "Sy",
            "Seck", "Mbaye", "Diouf", "Thiam", "Cissé",
            "Kane", "Dieng", "Niang", "Ndour", "Wade",
            "Tall", "Bâ", "Camara", "Touré", "Dramé",
            "Gassama", "Daff", "Sagna", "Badiane", "Mané",
            "Sonko", "Baldé", "Diedhiou", "Beye", "Ndao",
            "Lo", "Samb", "Gningue", "Bodian", "Coly",

            // 10 autres noms de famille africains
            "Mensah", "Okafor", "Nwosu", "Adeyemi", "Oluwole",
            "Mbeki", "Mahlangu", "Dlamini", "Chirwa", "Mwangi"
    };



    @Override
    public void run(String... args) throws Exception {
        log.info("Demarrage"); //trace/debug/info/warn/error
        long nbEtudiants = etudiantRepository.count();
        log.info("il existe {} étudiant(s) en base", nbEtudiants);

        if (nbEtudiants == 0) {
            log.warn("aucun etudfiant en base, initialisation des etudiants");
            int nbNEwEtudiant = (int)(Math.random()*20)+400;
            log.warn("{} seront crees", nbNEwEtudiant);
            for (int i=0; i<nbNEwEtudiant; i++) {
                int idxPrenom = (int)(Math.random()*prenomsAfricains.length);
                log.trace("indice prenom {}", idxPrenom);
                String prenom = prenomsAfricains[idxPrenom];
                log.trace("prenom {}", prenom);

                int idxNom = (int)(Math.random()*nomsFamilleAfricains.length);
                log.trace("indice nom {}", idxNom);
                String nom = nomsFamilleAfricains[idxNom];
                log.trace("nom {}", nom);

                Etudiant etudiant= new Etudiant();
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setEmail(prenom.charAt(0)+nom+i+"@groupeisi.com");
                etudiant.setNumCarte("2026GL"+(i+1));
                etudiantRepository.save(etudiant);
            }

        }else{
            log.info("il ya desja des données en base (pas d'initialisation a faire)");
        }



    }
}
