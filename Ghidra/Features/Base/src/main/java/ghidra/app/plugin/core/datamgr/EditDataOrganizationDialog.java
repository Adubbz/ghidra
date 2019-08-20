package ghidra.app.plugin.core.datamgr;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import docking.DialogComponentProvider;
import ghidra.program.model.data.DataOrganization;
import ghidra.program.model.data.DataOrganizationImpl;
import ghidra.util.HelpLocation;

public class EditDataOrganizationDialog extends DialogComponentProvider {
	
	private DataOrganizationImpl dataOrganization;
	
	private JPanel mainPanel;
	private DataOrganizationPanel organizationPanel;
	
	public EditDataOrganizationDialog(DataOrganizationImpl dataOrganization, String title) {
		super(title);
		this.dataOrganization = dataOrganization;
		this.organizationPanel = new DataOrganizationPanel();
		this.organizationPanel.setOrganization(dataOrganization);
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(this.organizationPanel, BorderLayout.CENTER);
		addWorkPanel(mainPanel);
		initialize();
	}

	private void initialize() {
		addOKButton();
		addCancelButton();
	}	
	
	@Override
	protected void okCallback() {
		close();
	}

	@Override
	protected void cancelCallback() {
		close();
	}
}
