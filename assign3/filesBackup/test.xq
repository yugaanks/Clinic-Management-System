declare namespace p = "http://www.example.org/schemas/clinic/patient";
declare namespace c = "http://www.example.org/schemas/clinic";
declare namespace t = "http://www.example.org/schemas/clinic/treatment";
declare namespace pro = "http://www.example.org/schemas/clinic/provider";



declare function local:getPatientTreatments($pid as element(c:Clinic),$db as node())
as element()*
{
   
   $pid/$db/p:Patient//p:treatments
            
};

let $clinic :=doc("instance1.xml")/c:Clinic

return local:getPatientTreatments($clinic,c:Clinic)