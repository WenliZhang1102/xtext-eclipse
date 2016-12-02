/**
 * generated by Xtext
 */
package org.eclipse.xtext.example.domainmodel.ui.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.domainmodel.domainmodel.Feature;
import org.eclipse.xtext.example.domainmodel.validation.IssueCodes;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.ui.quickfix.XbaseQuickfixProvider;

/**
 * Custom quickfixes.
 * See https://www.eclipse.org/Xtext/documentation/310_eclipse_support.html#quick-fixes
 */
@SuppressWarnings("all")
public class DomainmodelQuickfixProvider extends XbaseQuickfixProvider {
  @Fix(IssueCodes.INVALID_TYPE_NAME)
  public void fixTypeName(final Issue issue, final IssueResolutionAcceptor acceptor) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Capitalize name  of \'");
    String[] _data = issue.getData();
    String _get = _data[0];
    _builder.append(_get, "");
    _builder.append("\'");
    final IModification _function = (IModificationContext context) -> {
      IXtextDocument xtextDocument = context.getXtextDocument();
      Integer _offset = issue.getOffset();
      String firstLetter = xtextDocument.get((_offset).intValue(), 1);
      Integer _offset_1 = issue.getOffset();
      String _firstUpper = Strings.toFirstUpper(firstLetter);
      xtextDocument.replace((_offset_1).intValue(), 1, _firstUpper);
    };
    acceptor.accept(issue, "Capitalize name", _builder.toString(), 
      "upcase.png", _function);
  }
  
  @Fix(IssueCodes.INVALID_FEATURE_NAME)
  public void fixFeatureName(final Issue issue, final IssueResolutionAcceptor acceptor) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Uncapitalize name of \'");
    String[] _data = issue.getData();
    String _get = _data[0];
    _builder.append(_get, "");
    _builder.append("\'");
    final ISemanticModification _function = (EObject element, IModificationContext context) -> {
      String[] _data_1 = issue.getData();
      String _get_1 = _data_1[0];
      String _firstLower = Strings.toFirstLower(_get_1);
      ((Feature) element).setName(_firstLower);
    };
    acceptor.accept(issue, "Uncapitalize name", _builder.toString(), 
      "upcase.png", _function);
  }
  
  @Fix(IssueCodes.MISSING_TYPE)
  public void createReferenceType(final Issue issue, final IssueResolutionAcceptor acceptor) {
    this.createLinkingIssueResolutions(issue, acceptor);
  }
}