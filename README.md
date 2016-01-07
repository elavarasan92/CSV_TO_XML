# CSV_TO_XML
Converting given csv file to xml file using opencsv and pojoxml jars
In my output i am getting two tags with same name. It is something to do with the list collection.


Input CSV file 

nameOfIssuer,titleOfClass,cusip,value,sshPrnamt,sshPrnamtType,putCall,investmentDiscretion,otherManager,Sole,Shared,None
123 Co,COM,00206R102,4467000,126200,SH,Put,SOLE,12,0,0,126200
ABC INC,COM SER A,30420103,72540330,175950,PRN,Put,DFNF,1345613,79200,0,96750


Output Xml File


<?xml version="1.0" encoding="UTF-8"?>
<InformationTableList>
  <informationTableList>
    <InformationTable>
      <nameOfIssuer>123 Co</nameOfIssuer>
      <titleOfClass>COM</titleOfClass>
      <cusip>00206R102</cusip>
      <value>4467000</value>
      <sshPrnamt>126200</sshPrnamt>
      <sshPrnamtType>SH</sshPrnamtType>
      <putCall>Put</putCall>
      <investmentDiscretion>SOLE</investmentDiscretion>
      <otherManager>12</otherManager>
      <voting>
        <sole>79200</sole>
        <shared>0</shared>
        <none>96750</none>
      </voting>
    </InformationTable>
    <InformationTable>
      <nameOfIssuer>ABC INC</nameOfIssuer>
      <titleOfClass>COM SER A</titleOfClass>
      <cusip>30420103</cusip>
      <value>72540330</value>
      <sshPrnamt>175950</sshPrnamt>
      <sshPrnamtType>PRN</sshPrnamtType>
      <putCall>Put</putCall>
      <investmentDiscretion>DFNF</investmentDiscretion>
      <otherManager>1345613</otherManager>
      <voting>
        <sole>79200</sole>
        <shared>0</shared>
        <none>96750</none>
      </voting>
    </InformationTable>
  </informationTableList>
</InformationTableList>
