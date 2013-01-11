<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="span12">
<h2><s:property value="affiliate.name"/></h2>	
		<table class="table table-bordered">
  				<thead>
  					<tr>
  						<th>	
  							Nom de la formation
  						</th>
  						<th>
  							Date début
  						</th>
  						<th>
  							Date fin
  						</th>
  						<th>
  							Abonnement
  						</th>
  					</tr>
  				</thead>
  				<tbody>
  					<s:iterator value="formationList">
  						<tr>
  							<td>
  								<s:property value="name"/>
  							</td>
  							<td>
  								<s:property value="startDate"/>
  							</td>
  							<td>
  								<s:property value="endDate"/>
  							</td>
  							<td>
  								<s:url var="registerURL" namespace="/pages" method="subscribeInFormation" action="listAffiliate">
  									<s:param name="id" value="%{id}"/>
  								</s:url>
  								<s:a href="%{registerURL}" cssClass="btn btn-primary">
  								 s'adhérer
  								</s:a>
  							</td>
  						</tr>
  					</s:iterator>
  				</tbody>
  			</table>
  </div>