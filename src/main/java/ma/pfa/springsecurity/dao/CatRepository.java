package ma.pfa.springsecurity.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
import ma.pfa.springsecurity.service.model.Category;

/**
 * 
 * Ici, l'interface EmpRepository hérite de l'interface JpaRepository de Spring
 * DATA. Il faut juste préciser la classe "Modele" et le type de la classe qui
 * représente la clé primaire.
 * 
 * Spring Data prendra en charge l'implémentation des 04 méthode ci-dessous à
 * condition de réspecter la nomenclature supportée par Spring Data.
 * 
 * @Query offre la possibilité d'exécuter des requêtes plus complexes.
 *
 */
public interface CatRepository extends JpaRepository<Category, Long> {
	List<Category> findByName(String name);


}
