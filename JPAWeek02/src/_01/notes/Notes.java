package _01.notes;

public enum Notes {

}

//Entity RelationShip
//bir ili�kide olabilecek kavramlar

// -Role
// -Directionality
// -Cardinality
// -Ordinality/ Optionality

//Role kavram� :
//bir ili�ki/relatikonship i�in 2 taraf olmas� gerekli..
//birbiri ile ili�kili 2 tane Entity vard�r.
//Her entity'nin rolu olacakt�r. '


//Directionality
//bir iliskide , bir entity'inin , diger entinty gostermesi/isaret etmesi.

//2 entity'den  sadece biri digerini gosteriyorsa ; unidirectional
//ikisi de birbirini gosteriyorsa , bi directional

//Cardinality
//"nicalik"

//bir iliski ;

//onetoone
//onetomany
//manytoone
//manytomany

//Employee - Deparment (many employee - one department)
//Employee - Project (many employee - many project)
//Employee - Phone ( one employee - many phone )

//- Ordinality/Optionality
//Customer ve BillingInfo table/entity olsun
//diyelim ki n11.com a kayit olduk (customer kaydi olustu)
//henuz alisveris yapmadik. ortada billinginfo yok!
//tersten bakacak olursak ;
//ortada bir billinginfo varsa bu durumda customer kaydi olmak zorunda!

//BillingInfo -> Optional/Ordinality

