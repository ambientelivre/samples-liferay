package br.com.ambientelivre.custom.portlet;

import br.com.ambientelivre.custom.constants.CustomMVCPortletKeys;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author ambientelivre
 */
@Component(immediate = true, property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CustomMVC",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CustomMVCPortletKeys.CUSTOMMVC,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
}, service = Portlet.class)
public class CustomMVCPortlet extends MVCPortlet {

	// Default Render Method.
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		renderRequest.setAttribute("userName", "nilang");
		super.doView(renderRequest, renderResponse);
	}

	@ProcessAction(name = "addName")
	public void addName(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException {
		String userName = ParamUtil.get(actionRequest, "userName", StringPool.BLANK);
		actionRequest.setAttribute("userName", userName);
	}

}
