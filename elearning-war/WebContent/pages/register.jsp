<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<div class="container-fluid">
<div class="span6 offset3">
	<s:form action="registerStudent" theme="bootstrap" cssClass="form-horizontal">
		<s:push value="student">
			<h4>Informations du compte</h4>
			<s:textfield required="true" name="username" label="Nom d'utilisateur"
				tooltip="Veuillez indiquer votre nom d'utilisateur pour l'utilisation lors de la connexion" />
			<s:textfield required="true" name="email" key="email.label" tooltip="Enter your email" />
			<s:password required="true" name="password" key="password.label"
				tooltip="Le mot de passe" />
			<s:password required="true" name="confirmPassword" label="Répéter mot de passe"
				tooltip="Veuillez confirmer votre mot de passe" />
			<div class="separator"></div>
			<h4>Informations personnelles</h4>
			<s:textfield required="true" name="cin" label="Carte d'identité nationale" 
				tooltip="Veuillez indiquer votre carte d'identité nationale"/>
			<s:textfield name="firstName" key="firstname.label" 
				tooltip="Enter your firstname here"/>
			<s:textfield name="lastName" key="lastname.label" 
				tooltip="Enter your lastname here" />
			<s:radio required="true" tooltip="choissez parmi ces types"
			label="Etat civil" name="situation"
			list="#{'celibataire':'célibataire','married':'marié/mariée','veuf':'veuf/veuve'}" value="1" />
			<sj:datepicker name="birthday" id="birthday" changeYear="true" required="true"
				parentTheme="bootstrap" displayFormat="dd/mm/yy" label="Date de naissance"
				tooltip="Indiquer votre date de naissance" minDate="-50y 0m 0d"  />
			<s:select required="true" list="gender" headerValue="Je suis un/une..."
			headerKey="" name="sex" label="Genre"
			tooltip="Veuillez indiquer votre genre" />
			<s:textfield required="true" name="phone" label="Téléphone mobile" 
				tooltip="Veuillez indiquer votre numéro de téléphone" />
			<s:textfield name="fixedPhone" label="Téléphone fixe" 
				tooltip="Veuillez indiquer votre numéro de téléphone fixe" />
			<s:select required="true" list="gouvernorateSelect" name="gouvernorate" label="Gouvernorate"
			tooltip="Veuillez choisir votre gouvernorat"/>
			<s:textfield name="adress" key="adress.label" 
				tooltip="Enter your adress here" />			
			<s:textfield required="true" name="zipCode" label="Code postal" 
				tooltip="Veuillez indiquer votre code postal contenant exactement 4 chiffres" />	
			<s:select list="formationSelect" name="formations" onfocus="this.defaultIndex=this.selectedIndex;" onchange="this.selectedIndex=this.defaultIndex" label="Formation"/>
			<s:select list="affiliateSelect" name="" disabled="true" label="Filiale"/>
		</s:push>
		<s:hidden name="id" value="%{#request['id']}"/>
		<s:submit cssClass="btn btn-inverse offset7"
			label="terminer" />
	</s:form>
</div>
</div>