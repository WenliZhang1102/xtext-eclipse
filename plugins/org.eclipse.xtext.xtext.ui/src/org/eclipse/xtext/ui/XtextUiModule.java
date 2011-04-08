/*
 * generated by Xtext
 */
package org.eclipse.xtext.ui;

import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IComparator;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineNodeLabelProvider;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor;
import org.eclipse.xtext.xtext.ecoreInference.ProjectAwareXtendXtext2EcorePostProcessor;
import org.eclipse.xtext.xtext.ui.XtextHyperlinkHelper;
import org.eclipse.xtext.xtext.ui.editor.autoedit.XtextAutoEditStrategy;
import org.eclipse.xtext.xtext.ui.editor.folding.XtextGrammarFoldingRegionProvider;
import org.eclipse.xtext.xtext.ui.editor.outline.FilterTerminalRulesContribution;
import org.eclipse.xtext.xtext.ui.editor.outline.HideReturnTypesContribution;
import org.eclipse.xtext.xtext.ui.editor.outline.XtextOutlineNodeComparator;
import org.eclipse.xtext.xtext.ui.editor.outline.XtextOutlineNodeLabelProvider;
import org.eclipse.xtext.xtext.ui.editor.outline.XtextOutlinePage;
import org.eclipse.xtext.xtext.ui.editor.outline.XtextOutlineTreeProvider;
import org.eclipse.xtext.xtext.ui.editor.quickfix.XtextGrammarQuickfixProvider;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingCalculator;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectCreator;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class XtextUiModule extends org.eclipse.xtext.ui.AbstractXtextUiModule {
	public XtextUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(String.class)
				.annotatedWith(Names.named(XtextContentAssistProcessor.COMPLETION_AUTO_ACTIVATION_CHARS))
				.toInstance("[{");
	}

	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SemanticHighlightingCalculator.class;
	}

	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return SemanticHighlightingConfiguration.class;
	}

	public Class<? extends IProjectCreator> bindIProjectCreator() {
		return XtextProjectCreator.class;
	}

	@Override
	public ICharacterPairMatcher bindICharacterPairMatcher() {
		return new DefaultCharacterPairMatcher(new char[] { ':', ';', '{', '}', '(', ')', '[', ']' });
	}

	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return XtextAutoEditStrategy.class;
	}

	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() {
		return XtextGrammarFoldingRegionProvider.class;
	}
	
	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return XtextOutlinePage.class;
	}

	public Class<? extends IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return XtextOutlineTreeProvider.class;
	}

	public Class<? extends IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
		return XtextOutlineTreeProvider.class;
	}
	
	@Override
	public Class<? extends IComparator> bindOutlineFilterAndSorter$IComparator() {
		return XtextOutlineNodeComparator.class;
	}
	
	public Class<? extends OutlineNodeLabelProvider> bindOutlineNodeLabelProvider() {
		return XtextOutlineNodeLabelProvider.class;
	}
	
	public void configureFilterReturnTypesContribution(Binder binder) {
		binder.bind(IOutlineContribution.class)
				.annotatedWith(HideReturnTypesContribution.Annotation.class)
				.to(HideReturnTypesContribution.class);
	}

	public void configureFilterTerminalRulesContribution(Binder binder) {
		binder.bind(IOutlineContribution.class)
				.annotatedWith(FilterTerminalRulesContribution.Annotation.class)
				.to(FilterTerminalRulesContribution.class);
	}

	public Class<? extends IXtext2EcorePostProcessor> bindIXtext2EcorePostProcessor() {
		return ProjectAwareXtendXtext2EcorePostProcessor.class;
	}

	@SuppressWarnings("restriction")
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		return org.eclipse.xtext.builder.nature.NatureAddingEditorCallback.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider> bindIssueResolutionProvider() {
		return XtextGrammarQuickfixProvider.class;
	}

	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return XtextHyperlinkHelper.class;
	}

}
