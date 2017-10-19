package com.yakindu.solidity.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.yakindu.solidity.services.SolidityGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSolidityParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VERSION", "RULE_STRING", "RULE_ID", "RULE_BOOL", "RULE_INT", "RULE_DOUBLE", "RULE_FLOAT", "RULE_HEX", "RULE_BINARY", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'pragma'", "'solidity'", "';'", "'import'", "'as'", "'is'", "','", "'{'", "'}'", "'='", "'modifier'", "'('", "')'", "'_;'", "'function'", "'external'", "'public'", "'internal'", "'private'", "'constant'", "'returns'", "'event'", "'?'", "':'", "'.'", "'['", "']'", "'<'", "'>'", "'null'", "'&&'", "'||'", "'!'", "'^'", "'|'", "'&'", "'contract'", "'library'", "'interface'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'~'", "'<='", "'>='", "'=='", "'!='"
    };
    public static final int RULE_HEX=11;
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int RULE_VERSION=4;
    public static final int T__59=59;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=6;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__37=37;
    public static final int RULE_DOUBLE=9;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int RULE_WS=15;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_BOOL=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=10;
    public static final int T__46=46;
    public static final int RULE_BINARY=12;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalSolidityParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSolidityParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSolidityParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSolidity.g"; }



     	private SolidityGrammarAccess grammarAccess;

        public InternalSolidityParser(TokenStream input, SolidityGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "SolidityModel";
       	}

       	@Override
       	protected SolidityGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleSolidityModel"
    // InternalSolidity.g:65:1: entryRuleSolidityModel returns [EObject current=null] : iv_ruleSolidityModel= ruleSolidityModel EOF ;
    public final EObject entryRuleSolidityModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSolidityModel = null;


        try {
            // InternalSolidity.g:65:54: (iv_ruleSolidityModel= ruleSolidityModel EOF )
            // InternalSolidity.g:66:2: iv_ruleSolidityModel= ruleSolidityModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSolidityModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSolidityModel=ruleSolidityModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSolidityModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSolidityModel"


    // $ANTLR start "ruleSolidityModel"
    // InternalSolidity.g:72:1: ruleSolidityModel returns [EObject current=null] : ( (lv_sourceunit_0_0= ruleSourceUnit ) )* ;
    public final EObject ruleSolidityModel() throws RecognitionException {
        EObject current = null;

        EObject lv_sourceunit_0_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:78:2: ( ( (lv_sourceunit_0_0= ruleSourceUnit ) )* )
            // InternalSolidity.g:79:2: ( (lv_sourceunit_0_0= ruleSourceUnit ) )*
            {
            // InternalSolidity.g:79:2: ( (lv_sourceunit_0_0= ruleSourceUnit ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSolidity.g:80:3: (lv_sourceunit_0_0= ruleSourceUnit )
            	    {
            	    // InternalSolidity.g:80:3: (lv_sourceunit_0_0= ruleSourceUnit )
            	    // InternalSolidity.g:81:4: lv_sourceunit_0_0= ruleSourceUnit
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getSolidityModelAccess().getSourceunitSourceUnitParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_sourceunit_0_0=ruleSourceUnit();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getSolidityModelRule());
            	      				}
            	      				add(
            	      					current,
            	      					"sourceunit",
            	      					lv_sourceunit_0_0,
            	      					"com.yakindu.solidity.Solidity.SourceUnit");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSolidityModel"


    // $ANTLR start "entryRuleSourceUnit"
    // InternalSolidity.g:101:1: entryRuleSourceUnit returns [EObject current=null] : iv_ruleSourceUnit= ruleSourceUnit EOF ;
    public final EObject entryRuleSourceUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSourceUnit = null;


        try {
            // InternalSolidity.g:101:51: (iv_ruleSourceUnit= ruleSourceUnit EOF )
            // InternalSolidity.g:102:2: iv_ruleSourceUnit= ruleSourceUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSourceUnitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSourceUnit=ruleSourceUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSourceUnit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSourceUnit"


    // $ANTLR start "ruleSourceUnit"
    // InternalSolidity.g:108:1: ruleSourceUnit returns [EObject current=null] : ( () ( (lv_pragma_1_0= rulePragmaDirective ) ) ( (lv_imports_2_0= ruleImportDirective ) )* ( (lv_member_3_0= ruleContractDefinition ) )* ) ;
    public final EObject ruleSourceUnit() throws RecognitionException {
        EObject current = null;

        EObject lv_pragma_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_member_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:114:2: ( ( () ( (lv_pragma_1_0= rulePragmaDirective ) ) ( (lv_imports_2_0= ruleImportDirective ) )* ( (lv_member_3_0= ruleContractDefinition ) )* ) )
            // InternalSolidity.g:115:2: ( () ( (lv_pragma_1_0= rulePragmaDirective ) ) ( (lv_imports_2_0= ruleImportDirective ) )* ( (lv_member_3_0= ruleContractDefinition ) )* )
            {
            // InternalSolidity.g:115:2: ( () ( (lv_pragma_1_0= rulePragmaDirective ) ) ( (lv_imports_2_0= ruleImportDirective ) )* ( (lv_member_3_0= ruleContractDefinition ) )* )
            // InternalSolidity.g:116:3: () ( (lv_pragma_1_0= rulePragmaDirective ) ) ( (lv_imports_2_0= ruleImportDirective ) )* ( (lv_member_3_0= ruleContractDefinition ) )*
            {
            // InternalSolidity.g:116:3: ()
            // InternalSolidity.g:117:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSourceUnitAccess().getSourceUnitAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:123:3: ( (lv_pragma_1_0= rulePragmaDirective ) )
            // InternalSolidity.g:124:4: (lv_pragma_1_0= rulePragmaDirective )
            {
            // InternalSolidity.g:124:4: (lv_pragma_1_0= rulePragmaDirective )
            // InternalSolidity.g:125:5: lv_pragma_1_0= rulePragmaDirective
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSourceUnitAccess().getPragmaPragmaDirectiveParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_pragma_1_0=rulePragmaDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSourceUnitRule());
              					}
              					set(
              						current,
              						"pragma",
              						lv_pragma_1_0,
              						"com.yakindu.solidity.Solidity.PragmaDirective");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSolidity.g:142:3: ( (lv_imports_2_0= ruleImportDirective ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==20) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSolidity.g:143:4: (lv_imports_2_0= ruleImportDirective )
            	    {
            	    // InternalSolidity.g:143:4: (lv_imports_2_0= ruleImportDirective )
            	    // InternalSolidity.g:144:5: lv_imports_2_0= ruleImportDirective
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSourceUnitAccess().getImportsImportDirectiveParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_imports_2_0=ruleImportDirective();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSourceUnitRule());
            	      					}
            	      					add(
            	      						current,
            	      						"imports",
            	      						lv_imports_2_0,
            	      						"com.yakindu.solidity.Solidity.ImportDirective");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalSolidity.g:161:3: ( (lv_member_3_0= ruleContractDefinition ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=53 && LA3_0<=55)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSolidity.g:162:4: (lv_member_3_0= ruleContractDefinition )
            	    {
            	    // InternalSolidity.g:162:4: (lv_member_3_0= ruleContractDefinition )
            	    // InternalSolidity.g:163:5: lv_member_3_0= ruleContractDefinition
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSourceUnitAccess().getMemberContractDefinitionParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_member_3_0=ruleContractDefinition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSourceUnitRule());
            	      					}
            	      					add(
            	      						current,
            	      						"member",
            	      						lv_member_3_0,
            	      						"com.yakindu.solidity.Solidity.ContractDefinition");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSourceUnit"


    // $ANTLR start "entryRulePragmaDirective"
    // InternalSolidity.g:184:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalSolidity.g:184:56: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalSolidity.g:185:2: iv_rulePragmaDirective= rulePragmaDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPragmaDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePragmaDirective=rulePragmaDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePragmaDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePragmaDirective"


    // $ANTLR start "rulePragmaDirective"
    // InternalSolidity.g:191:1: rulePragmaDirective returns [EObject current=null] : ( () otherlv_1= 'pragma' otherlv_2= 'solidity' ( (lv_version_3_0= RULE_VERSION ) ) otherlv_4= ';' ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_version_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalSolidity.g:197:2: ( ( () otherlv_1= 'pragma' otherlv_2= 'solidity' ( (lv_version_3_0= RULE_VERSION ) ) otherlv_4= ';' ) )
            // InternalSolidity.g:198:2: ( () otherlv_1= 'pragma' otherlv_2= 'solidity' ( (lv_version_3_0= RULE_VERSION ) ) otherlv_4= ';' )
            {
            // InternalSolidity.g:198:2: ( () otherlv_1= 'pragma' otherlv_2= 'solidity' ( (lv_version_3_0= RULE_VERSION ) ) otherlv_4= ';' )
            // InternalSolidity.g:199:3: () otherlv_1= 'pragma' otherlv_2= 'solidity' ( (lv_version_3_0= RULE_VERSION ) ) otherlv_4= ';'
            {
            // InternalSolidity.g:199:3: ()
            // InternalSolidity.g:200:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPragmaDirectiveAccess().getPragmaDirectiveAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPragmaDirectiveAccess().getPragmaKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,18,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPragmaDirectiveAccess().getSolidityKeyword_2());
              		
            }
            // InternalSolidity.g:214:3: ( (lv_version_3_0= RULE_VERSION ) )
            // InternalSolidity.g:215:4: (lv_version_3_0= RULE_VERSION )
            {
            // InternalSolidity.g:215:4: (lv_version_3_0= RULE_VERSION )
            // InternalSolidity.g:216:5: lv_version_3_0= RULE_VERSION
            {
            lv_version_3_0=(Token)match(input,RULE_VERSION,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_version_3_0, grammarAccess.getPragmaDirectiveAccess().getVersionVERSIONTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPragmaDirectiveRule());
              					}
              					setWithLastConsumed(
              						current,
              						"version",
              						lv_version_3_0,
              						"com.yakindu.solidity.Solidity.VERSION");
              				
            }

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getPragmaDirectiveAccess().getSemicolonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePragmaDirective"


    // $ANTLR start "entryRuleImportDirective"
    // InternalSolidity.g:240:1: entryRuleImportDirective returns [EObject current=null] : iv_ruleImportDirective= ruleImportDirective EOF ;
    public final EObject entryRuleImportDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportDirective = null;


        try {
            // InternalSolidity.g:240:56: (iv_ruleImportDirective= ruleImportDirective EOF )
            // InternalSolidity.g:241:2: iv_ruleImportDirective= ruleImportDirective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportDirectiveRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportDirective=ruleImportDirective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportDirective; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportDirective"


    // $ANTLR start "ruleImportDirective"
    // InternalSolidity.g:247:1: ruleImportDirective returns [EObject current=null] : ( () otherlv_1= 'import' ( (lv_importedNamespace_2_0= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_STRING ) ) )? otherlv_5= ';' ) ;
    public final EObject ruleImportDirective() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_importedNamespace_2_0=null;
        Token otherlv_3=null;
        Token lv_alias_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalSolidity.g:253:2: ( ( () otherlv_1= 'import' ( (lv_importedNamespace_2_0= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_STRING ) ) )? otherlv_5= ';' ) )
            // InternalSolidity.g:254:2: ( () otherlv_1= 'import' ( (lv_importedNamespace_2_0= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_STRING ) ) )? otherlv_5= ';' )
            {
            // InternalSolidity.g:254:2: ( () otherlv_1= 'import' ( (lv_importedNamespace_2_0= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_STRING ) ) )? otherlv_5= ';' )
            // InternalSolidity.g:255:3: () otherlv_1= 'import' ( (lv_importedNamespace_2_0= RULE_STRING ) ) (otherlv_3= 'as' ( (lv_alias_4_0= RULE_STRING ) ) )? otherlv_5= ';'
            {
            // InternalSolidity.g:255:3: ()
            // InternalSolidity.g:256:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getImportDirectiveAccess().getImportDirectiveAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getImportDirectiveAccess().getImportKeyword_1());
              		
            }
            // InternalSolidity.g:266:3: ( (lv_importedNamespace_2_0= RULE_STRING ) )
            // InternalSolidity.g:267:4: (lv_importedNamespace_2_0= RULE_STRING )
            {
            // InternalSolidity.g:267:4: (lv_importedNamespace_2_0= RULE_STRING )
            // InternalSolidity.g:268:5: lv_importedNamespace_2_0= RULE_STRING
            {
            lv_importedNamespace_2_0=(Token)match(input,RULE_STRING,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_importedNamespace_2_0, grammarAccess.getImportDirectiveAccess().getImportedNamespaceSTRINGTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportDirectiveRule());
              					}
              					setWithLastConsumed(
              						current,
              						"importedNamespace",
              						lv_importedNamespace_2_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            // InternalSolidity.g:284:3: (otherlv_3= 'as' ( (lv_alias_4_0= RULE_STRING ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalSolidity.g:285:4: otherlv_3= 'as' ( (lv_alias_4_0= RULE_STRING ) )
                    {
                    otherlv_3=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getImportDirectiveAccess().getAsKeyword_3_0());
                      			
                    }
                    // InternalSolidity.g:289:4: ( (lv_alias_4_0= RULE_STRING ) )
                    // InternalSolidity.g:290:5: (lv_alias_4_0= RULE_STRING )
                    {
                    // InternalSolidity.g:290:5: (lv_alias_4_0= RULE_STRING )
                    // InternalSolidity.g:291:6: lv_alias_4_0= RULE_STRING
                    {
                    lv_alias_4_0=(Token)match(input,RULE_STRING,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_alias_4_0, grammarAccess.getImportDirectiveAccess().getAliasSTRINGTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getImportDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"alias",
                      							lv_alias_4_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getImportDirectiveAccess().getSemicolonKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportDirective"


    // $ANTLR start "entryRuleContractDefinition"
    // InternalSolidity.g:316:1: entryRuleContractDefinition returns [EObject current=null] : iv_ruleContractDefinition= ruleContractDefinition EOF ;
    public final EObject entryRuleContractDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractDefinition = null;


        try {
            // InternalSolidity.g:316:59: (iv_ruleContractDefinition= ruleContractDefinition EOF )
            // InternalSolidity.g:317:2: iv_ruleContractDefinition= ruleContractDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContractDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContractDefinition=ruleContractDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContractDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractDefinition"


    // $ANTLR start "ruleContractDefinition"
    // InternalSolidity.g:323:1: ruleContractDefinition returns [EObject current=null] : ( () ( (lv_type_1_0= ruleContractType ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( ( ruleQID ) ) (otherlv_5= ',' ( ( ruleQID ) ) )* )? otherlv_7= '{' ( (lv_features_8_0= ruleContractPart ) )* otherlv_9= '}' ) ;
    public final EObject ruleContractDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_features_8_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:329:2: ( ( () ( (lv_type_1_0= ruleContractType ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( ( ruleQID ) ) (otherlv_5= ',' ( ( ruleQID ) ) )* )? otherlv_7= '{' ( (lv_features_8_0= ruleContractPart ) )* otherlv_9= '}' ) )
            // InternalSolidity.g:330:2: ( () ( (lv_type_1_0= ruleContractType ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( ( ruleQID ) ) (otherlv_5= ',' ( ( ruleQID ) ) )* )? otherlv_7= '{' ( (lv_features_8_0= ruleContractPart ) )* otherlv_9= '}' )
            {
            // InternalSolidity.g:330:2: ( () ( (lv_type_1_0= ruleContractType ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( ( ruleQID ) ) (otherlv_5= ',' ( ( ruleQID ) ) )* )? otherlv_7= '{' ( (lv_features_8_0= ruleContractPart ) )* otherlv_9= '}' )
            // InternalSolidity.g:331:3: () ( (lv_type_1_0= ruleContractType ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= 'is' ( ( ruleQID ) ) (otherlv_5= ',' ( ( ruleQID ) ) )* )? otherlv_7= '{' ( (lv_features_8_0= ruleContractPart ) )* otherlv_9= '}'
            {
            // InternalSolidity.g:331:3: ()
            // InternalSolidity.g:332:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getContractDefinitionAccess().getContractDefinitionAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:338:3: ( (lv_type_1_0= ruleContractType ) )
            // InternalSolidity.g:339:4: (lv_type_1_0= ruleContractType )
            {
            // InternalSolidity.g:339:4: (lv_type_1_0= ruleContractType )
            // InternalSolidity.g:340:5: lv_type_1_0= ruleContractType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContractDefinitionAccess().getTypeContractTypeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_type_1_0=ruleContractType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getContractDefinitionRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"com.yakindu.solidity.Solidity.ContractType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSolidity.g:357:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalSolidity.g:358:4: (lv_name_2_0= RULE_ID )
            {
            // InternalSolidity.g:358:4: (lv_name_2_0= RULE_ID )
            // InternalSolidity.g:359:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getContractDefinitionAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getContractDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSolidity.g:375:3: (otherlv_3= 'is' ( ( ruleQID ) ) (otherlv_5= ',' ( ( ruleQID ) ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==22) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalSolidity.g:376:4: otherlv_3= 'is' ( ( ruleQID ) ) (otherlv_5= ',' ( ( ruleQID ) ) )*
                    {
                    otherlv_3=(Token)match(input,22,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getContractDefinitionAccess().getIsKeyword_3_0());
                      			
                    }
                    // InternalSolidity.g:380:4: ( ( ruleQID ) )
                    // InternalSolidity.g:381:5: ( ruleQID )
                    {
                    // InternalSolidity.g:381:5: ( ruleQID )
                    // InternalSolidity.g:382:6: ruleQID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getContractDefinitionRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContractDefinitionAccess().getSuperTypesComplexTypeCrossReference_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_13);
                    ruleQID();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSolidity.g:396:4: (otherlv_5= ',' ( ( ruleQID ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==23) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalSolidity.g:397:5: otherlv_5= ',' ( ( ruleQID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,23,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getContractDefinitionAccess().getCommaKeyword_3_2_0());
                    	      				
                    	    }
                    	    // InternalSolidity.g:401:5: ( ( ruleQID ) )
                    	    // InternalSolidity.g:402:6: ( ruleQID )
                    	    {
                    	    // InternalSolidity.g:402:6: ( ruleQID )
                    	    // InternalSolidity.g:403:7: ruleQID
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElement(grammarAccess.getContractDefinitionRule());
                    	      							}
                    	      						
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getContractDefinitionAccess().getSuperTypesComplexTypeCrossReference_3_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_13);
                    	    ruleQID();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,24,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getContractDefinitionAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalSolidity.g:423:3: ( (lv_features_8_0= ruleContractPart ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID||LA7_0==27||LA7_0==31||LA7_0==38) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSolidity.g:424:4: (lv_features_8_0= ruleContractPart )
            	    {
            	    // InternalSolidity.g:424:4: (lv_features_8_0= ruleContractPart )
            	    // InternalSolidity.g:425:5: lv_features_8_0= ruleContractPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getContractDefinitionAccess().getFeaturesContractPartParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_features_8_0=ruleContractPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getContractDefinitionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"features",
            	      						lv_features_8_0,
            	      						"com.yakindu.solidity.Solidity.ContractPart");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_9=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getContractDefinitionAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractDefinition"


    // $ANTLR start "entryRuleContractPart"
    // InternalSolidity.g:450:1: entryRuleContractPart returns [EObject current=null] : iv_ruleContractPart= ruleContractPart EOF ;
    public final EObject entryRuleContractPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractPart = null;


        try {
            // InternalSolidity.g:450:53: (iv_ruleContractPart= ruleContractPart EOF )
            // InternalSolidity.g:451:2: iv_ruleContractPart= ruleContractPart EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getContractPartRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleContractPart=ruleContractPart();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleContractPart; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractPart"


    // $ANTLR start "ruleContractPart"
    // InternalSolidity.g:457:1: ruleContractPart returns [EObject current=null] : (this_VariableDefinition_0= ruleVariableDefinition | this_ModifierDefinition_1= ruleModifierDefinition | this_FunctionDefinition_2= ruleFunctionDefinition | this_EventDefinition_3= ruleEventDefinition ) ;
    public final EObject ruleContractPart() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDefinition_0 = null;

        EObject this_ModifierDefinition_1 = null;

        EObject this_FunctionDefinition_2 = null;

        EObject this_EventDefinition_3 = null;



        	enterRule();

        try {
            // InternalSolidity.g:463:2: ( (this_VariableDefinition_0= ruleVariableDefinition | this_ModifierDefinition_1= ruleModifierDefinition | this_FunctionDefinition_2= ruleFunctionDefinition | this_EventDefinition_3= ruleEventDefinition ) )
            // InternalSolidity.g:464:2: (this_VariableDefinition_0= ruleVariableDefinition | this_ModifierDefinition_1= ruleModifierDefinition | this_FunctionDefinition_2= ruleFunctionDefinition | this_EventDefinition_3= ruleEventDefinition )
            {
            // InternalSolidity.g:464:2: (this_VariableDefinition_0= ruleVariableDefinition | this_ModifierDefinition_1= ruleModifierDefinition | this_FunctionDefinition_2= ruleFunctionDefinition | this_EventDefinition_3= ruleEventDefinition )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt8=1;
                }
                break;
            case 27:
                {
                alt8=2;
                }
                break;
            case 31:
                {
                alt8=3;
                }
                break;
            case 38:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalSolidity.g:465:3: this_VariableDefinition_0= ruleVariableDefinition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getContractPartAccess().getVariableDefinitionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableDefinition_0=ruleVariableDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableDefinition_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:474:3: this_ModifierDefinition_1= ruleModifierDefinition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getContractPartAccess().getModifierDefinitionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ModifierDefinition_1=ruleModifierDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ModifierDefinition_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSolidity.g:483:3: this_FunctionDefinition_2= ruleFunctionDefinition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getContractPartAccess().getFunctionDefinitionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionDefinition_2=ruleFunctionDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionDefinition_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSolidity.g:492:3: this_EventDefinition_3= ruleEventDefinition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getContractPartAccess().getEventDefinitionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EventDefinition_3=ruleEventDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EventDefinition_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractPart"


    // $ANTLR start "entryRuleVariableDefinition"
    // InternalSolidity.g:504:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // InternalSolidity.g:504:59: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // InternalSolidity.g:505:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDefinition"


    // $ANTLR start "ruleVariableDefinition"
    // InternalSolidity.g:511:1: ruleVariableDefinition returns [EObject current=null] : ( () ( (lv_typeSpecifier_1_0= ruleTypeSpecifier ) ) ( (lv_visibility_2_0= ruleVisibility ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( (lv_initialValue_5_0= ruleExpression ) ) )? otherlv_6= ';' ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_typeSpecifier_1_0 = null;

        Enumerator lv_visibility_2_0 = null;

        EObject lv_initialValue_5_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:517:2: ( ( () ( (lv_typeSpecifier_1_0= ruleTypeSpecifier ) ) ( (lv_visibility_2_0= ruleVisibility ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( (lv_initialValue_5_0= ruleExpression ) ) )? otherlv_6= ';' ) )
            // InternalSolidity.g:518:2: ( () ( (lv_typeSpecifier_1_0= ruleTypeSpecifier ) ) ( (lv_visibility_2_0= ruleVisibility ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( (lv_initialValue_5_0= ruleExpression ) ) )? otherlv_6= ';' )
            {
            // InternalSolidity.g:518:2: ( () ( (lv_typeSpecifier_1_0= ruleTypeSpecifier ) ) ( (lv_visibility_2_0= ruleVisibility ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( (lv_initialValue_5_0= ruleExpression ) ) )? otherlv_6= ';' )
            // InternalSolidity.g:519:3: () ( (lv_typeSpecifier_1_0= ruleTypeSpecifier ) ) ( (lv_visibility_2_0= ruleVisibility ) )? ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( (lv_initialValue_5_0= ruleExpression ) ) )? otherlv_6= ';'
            {
            // InternalSolidity.g:519:3: ()
            // InternalSolidity.g:520:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableDefinitionAccess().getVariableDefinitionAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:526:3: ( (lv_typeSpecifier_1_0= ruleTypeSpecifier ) )
            // InternalSolidity.g:527:4: (lv_typeSpecifier_1_0= ruleTypeSpecifier )
            {
            // InternalSolidity.g:527:4: (lv_typeSpecifier_1_0= ruleTypeSpecifier )
            // InternalSolidity.g:528:5: lv_typeSpecifier_1_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDefinitionAccess().getTypeSpecifierTypeSpecifierParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_15);
            lv_typeSpecifier_1_0=ruleTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
              					}
              					set(
              						current,
              						"typeSpecifier",
              						lv_typeSpecifier_1_0,
              						"org.yakindu.base.expressions.Expressions.TypeSpecifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSolidity.g:545:3: ( (lv_visibility_2_0= ruleVisibility ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=33 && LA9_0<=36)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSolidity.g:546:4: (lv_visibility_2_0= ruleVisibility )
                    {
                    // InternalSolidity.g:546:4: (lv_visibility_2_0= ruleVisibility )
                    // InternalSolidity.g:547:5: lv_visibility_2_0= ruleVisibility
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVariableDefinitionAccess().getVisibilityVisibilityEnumRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_11);
                    lv_visibility_2_0=ruleVisibility();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
                      					}
                      					set(
                      						current,
                      						"visibility",
                      						lv_visibility_2_0,
                      						"com.yakindu.solidity.Solidity.Visibility");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSolidity.g:564:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalSolidity.g:565:4: (lv_name_3_0= RULE_ID )
            {
            // InternalSolidity.g:565:4: (lv_name_3_0= RULE_ID )
            // InternalSolidity.g:566:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_3_0, grammarAccess.getVariableDefinitionAccess().getNameIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_3_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSolidity.g:582:3: (otherlv_4= '=' ( (lv_initialValue_5_0= ruleExpression ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==26) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSolidity.g:583:4: otherlv_4= '=' ( (lv_initialValue_5_0= ruleExpression ) )
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getVariableDefinitionAccess().getEqualsSignKeyword_4_0());
                      			
                    }
                    // InternalSolidity.g:587:4: ( (lv_initialValue_5_0= ruleExpression ) )
                    // InternalSolidity.g:588:5: (lv_initialValue_5_0= ruleExpression )
                    {
                    // InternalSolidity.g:588:5: (lv_initialValue_5_0= ruleExpression )
                    // InternalSolidity.g:589:6: lv_initialValue_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueExpressionParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_8);
                    lv_initialValue_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
                      						}
                      						set(
                      							current,
                      							"initialValue",
                      							lv_initialValue_5_0,
                      							"org.yakindu.base.expressions.Expressions.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getVariableDefinitionAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDefinition"


    // $ANTLR start "entryRuleModifierDefinition"
    // InternalSolidity.g:615:1: entryRuleModifierDefinition returns [EObject current=null] : iv_ruleModifierDefinition= ruleModifierDefinition EOF ;
    public final EObject entryRuleModifierDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierDefinition = null;


        try {
            // InternalSolidity.g:615:59: (iv_ruleModifierDefinition= ruleModifierDefinition EOF )
            // InternalSolidity.g:616:2: iv_ruleModifierDefinition= ruleModifierDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModifierDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModifierDefinition=ruleModifierDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModifierDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifierDefinition"


    // $ANTLR start "ruleModifierDefinition"
    // InternalSolidity.g:622:1: ruleModifierDefinition returns [EObject current=null] : ( () otherlv_1= 'modifier' ( (lv_name_2_0= RULE_ID ) ) ( (lv_list_3_0= ruleParameterList ) ) ( (lv_block_4_0= ruleBlock ) ) ) ;
    public final EObject ruleModifierDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_list_3_0 = null;

        EObject lv_block_4_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:628:2: ( ( () otherlv_1= 'modifier' ( (lv_name_2_0= RULE_ID ) ) ( (lv_list_3_0= ruleParameterList ) ) ( (lv_block_4_0= ruleBlock ) ) ) )
            // InternalSolidity.g:629:2: ( () otherlv_1= 'modifier' ( (lv_name_2_0= RULE_ID ) ) ( (lv_list_3_0= ruleParameterList ) ) ( (lv_block_4_0= ruleBlock ) ) )
            {
            // InternalSolidity.g:629:2: ( () otherlv_1= 'modifier' ( (lv_name_2_0= RULE_ID ) ) ( (lv_list_3_0= ruleParameterList ) ) ( (lv_block_4_0= ruleBlock ) ) )
            // InternalSolidity.g:630:3: () otherlv_1= 'modifier' ( (lv_name_2_0= RULE_ID ) ) ( (lv_list_3_0= ruleParameterList ) ) ( (lv_block_4_0= ruleBlock ) )
            {
            // InternalSolidity.g:630:3: ()
            // InternalSolidity.g:631:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getModifierDefinitionAccess().getModifierDefinitionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,27,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getModifierDefinitionAccess().getModifierKeyword_1());
              		
            }
            // InternalSolidity.g:641:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalSolidity.g:642:4: (lv_name_2_0= RULE_ID )
            {
            // InternalSolidity.g:642:4: (lv_name_2_0= RULE_ID )
            // InternalSolidity.g:643:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getModifierDefinitionAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getModifierDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSolidity.g:659:3: ( (lv_list_3_0= ruleParameterList ) )
            // InternalSolidity.g:660:4: (lv_list_3_0= ruleParameterList )
            {
            // InternalSolidity.g:660:4: (lv_list_3_0= ruleParameterList )
            // InternalSolidity.g:661:5: lv_list_3_0= ruleParameterList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModifierDefinitionAccess().getListParameterListParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_list_3_0=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModifierDefinitionRule());
              					}
              					set(
              						current,
              						"list",
              						lv_list_3_0,
              						"com.yakindu.solidity.Solidity.ParameterList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSolidity.g:678:3: ( (lv_block_4_0= ruleBlock ) )
            // InternalSolidity.g:679:4: (lv_block_4_0= ruleBlock )
            {
            // InternalSolidity.g:679:4: (lv_block_4_0= ruleBlock )
            // InternalSolidity.g:680:5: lv_block_4_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModifierDefinitionAccess().getBlockBlockParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_4_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModifierDefinitionRule());
              					}
              					add(
              						current,
              						"block",
              						lv_block_4_0,
              						"com.yakindu.solidity.Solidity.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifierDefinition"


    // $ANTLR start "entryRuleParameterList"
    // InternalSolidity.g:701:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalSolidity.g:701:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalSolidity.g:702:2: iv_ruleParameterList= ruleParameterList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameterList=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameterList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterList"


    // $ANTLR start "ruleParameterList"
    // InternalSolidity.g:708:1: ruleParameterList returns [EObject current=null] : (otherlv_0= '(' () ( (lv_parameter_2_0= ruleParameter ) )? (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameter_2_0 = null;

        EObject lv_parameter_4_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:714:2: ( (otherlv_0= '(' () ( (lv_parameter_2_0= ruleParameter ) )? (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )* otherlv_5= ')' ) )
            // InternalSolidity.g:715:2: (otherlv_0= '(' () ( (lv_parameter_2_0= ruleParameter ) )? (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )* otherlv_5= ')' )
            {
            // InternalSolidity.g:715:2: (otherlv_0= '(' () ( (lv_parameter_2_0= ruleParameter ) )? (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )* otherlv_5= ')' )
            // InternalSolidity.g:716:3: otherlv_0= '(' () ( (lv_parameter_2_0= ruleParameter ) )? (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,28,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParameterListAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalSolidity.g:720:3: ()
            // InternalSolidity.g:721:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterListAccess().getParameterListAction_1(),
              					current);
              			
            }

            }

            // InternalSolidity.g:727:3: ( (lv_parameter_2_0= ruleParameter ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSolidity.g:728:4: (lv_parameter_2_0= ruleParameter )
                    {
                    // InternalSolidity.g:728:4: (lv_parameter_2_0= ruleParameter )
                    // InternalSolidity.g:729:5: lv_parameter_2_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getParameterListAccess().getParameterParameterParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_21);
                    lv_parameter_2_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getParameterListRule());
                      					}
                      					add(
                      						current,
                      						"parameter",
                      						lv_parameter_2_0,
                      						"com.yakindu.solidity.Solidity.Parameter");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSolidity.g:746:3: (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalSolidity.g:747:4: otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalSolidity.g:751:4: ( (lv_parameter_4_0= ruleParameter ) )
            	    // InternalSolidity.g:752:5: (lv_parameter_4_0= ruleParameter )
            	    {
            	    // InternalSolidity.g:752:5: (lv_parameter_4_0= ruleParameter )
            	    // InternalSolidity.g:753:6: lv_parameter_4_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getParameterParameterParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_parameter_4_0=ruleParameter();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getParameterListRule());
            	      						}
            	      						add(
            	      							current,
            	      							"parameter",
            	      							lv_parameter_4_0,
            	      							"com.yakindu.solidity.Solidity.Parameter");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_5=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getParameterListAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterList"


    // $ANTLR start "entryRuleBlock"
    // InternalSolidity.g:779:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalSolidity.g:779:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalSolidity.g:780:2: iv_ruleBlock= ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalSolidity.g:786:1: ruleBlock returns [EObject current=null] : (otherlv_0= '{' () ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:792:2: ( (otherlv_0= '{' () ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) )
            // InternalSolidity.g:793:2: (otherlv_0= '{' () ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            {
            // InternalSolidity.g:793:2: (otherlv_0= '{' () ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            // InternalSolidity.g:794:3: otherlv_0= '{' () ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            // InternalSolidity.g:798:3: ()
            // InternalSolidity.g:799:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockAccess().getBlockAction_1(),
              					current);
              			
            }

            }

            // InternalSolidity.g:805:3: ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=RULE_STRING && LA13_0<=RULE_BINARY)||LA13_0==28||LA13_0==30||LA13_0==46||LA13_0==49||(LA13_0>=68 && LA13_0<=69)||LA13_0==73) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSolidity.g:806:4: ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';'
            	    {
            	    // InternalSolidity.g:806:4: ( (lv_expression_2_0= ruleExpression ) )
            	    // InternalSolidity.g:807:5: (lv_expression_2_0= ruleExpression )
            	    {
            	    // InternalSolidity.g:807:5: (lv_expression_2_0= ruleExpression )
            	    // InternalSolidity.g:808:6: lv_expression_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBlockAccess().getExpressionExpressionParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_expression_2_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBlockRule());
            	      						}
            	      						add(
            	      							current,
            	      							"expression",
            	      							lv_expression_2_0,
            	      							"org.yakindu.base.expressions.Expressions.Expression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,19,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getSemicolonKeyword_2_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleLiteral"
    // InternalSolidity.g:838:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalSolidity.g:838:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalSolidity.g:839:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalSolidity.g:845:1: ruleLiteral returns [EObject current=null] : (this_Literal_0= superLiteral | this_ModifierInvocationLiteral_1= ruleModifierInvocationLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_ModifierInvocationLiteral_1 = null;



        	enterRule();

        try {
            // InternalSolidity.g:851:2: ( (this_Literal_0= superLiteral | this_ModifierInvocationLiteral_1= ruleModifierInvocationLiteral ) )
            // InternalSolidity.g:852:2: (this_Literal_0= superLiteral | this_ModifierInvocationLiteral_1= ruleModifierInvocationLiteral )
            {
            // InternalSolidity.g:852:2: (this_Literal_0= superLiteral | this_ModifierInvocationLiteral_1= ruleModifierInvocationLiteral )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_STRING||(LA14_0>=RULE_BOOL && LA14_0<=RULE_BINARY)||LA14_0==46) ) {
                alt14=1;
            }
            else if ( (LA14_0==30) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalSolidity.g:853:3: this_Literal_0= superLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Literal_0=superLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Literal_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:862:3: this_ModifierInvocationLiteral_1= ruleModifierInvocationLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getModifierInvocationLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ModifierInvocationLiteral_1=ruleModifierInvocationLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ModifierInvocationLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleModifierInvocationLiteral"
    // InternalSolidity.g:874:1: entryRuleModifierInvocationLiteral returns [EObject current=null] : iv_ruleModifierInvocationLiteral= ruleModifierInvocationLiteral EOF ;
    public final EObject entryRuleModifierInvocationLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierInvocationLiteral = null;


        try {
            // InternalSolidity.g:874:66: (iv_ruleModifierInvocationLiteral= ruleModifierInvocationLiteral EOF )
            // InternalSolidity.g:875:2: iv_ruleModifierInvocationLiteral= ruleModifierInvocationLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModifierInvocationLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModifierInvocationLiteral=ruleModifierInvocationLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModifierInvocationLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifierInvocationLiteral"


    // $ANTLR start "ruleModifierInvocationLiteral"
    // InternalSolidity.g:881:1: ruleModifierInvocationLiteral returns [EObject current=null] : ( () otherlv_1= '_;' ) ;
    public final EObject ruleModifierInvocationLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalSolidity.g:887:2: ( ( () otherlv_1= '_;' ) )
            // InternalSolidity.g:888:2: ( () otherlv_1= '_;' )
            {
            // InternalSolidity.g:888:2: ( () otherlv_1= '_;' )
            // InternalSolidity.g:889:3: () otherlv_1= '_;'
            {
            // InternalSolidity.g:889:3: ()
            // InternalSolidity.g:890:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getModifierInvocationLiteralAccess().getModifierInvocationLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getModifierInvocationLiteralAccess().get_Keyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifierInvocationLiteral"


    // $ANTLR start "entryRuleFunctionDefinition"
    // InternalSolidity.g:904:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalSolidity.g:904:59: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalSolidity.g:905:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDefinition=ruleFunctionDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDefinition"


    // $ANTLR start "ruleFunctionDefinition"
    // InternalSolidity.g:911:1: ruleFunctionDefinition returns [EObject current=null] : ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= 'external' | otherlv_9= 'public' | otherlv_10= 'internal' | otherlv_11= 'private' | otherlv_12= 'constant' )* (otherlv_13= 'returns' ( (lv_returnTypes_14_0= ruleTypeSpecifier ) )* )? (otherlv_15= ';' | ( (lv_block_16_0= ruleBlock ) ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_parameters_4_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_returnTypes_14_0 = null;

        EObject lv_block_16_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:917:2: ( ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= 'external' | otherlv_9= 'public' | otherlv_10= 'internal' | otherlv_11= 'private' | otherlv_12= 'constant' )* (otherlv_13= 'returns' ( (lv_returnTypes_14_0= ruleTypeSpecifier ) )* )? (otherlv_15= ';' | ( (lv_block_16_0= ruleBlock ) ) ) ) )
            // InternalSolidity.g:918:2: ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= 'external' | otherlv_9= 'public' | otherlv_10= 'internal' | otherlv_11= 'private' | otherlv_12= 'constant' )* (otherlv_13= 'returns' ( (lv_returnTypes_14_0= ruleTypeSpecifier ) )* )? (otherlv_15= ';' | ( (lv_block_16_0= ruleBlock ) ) ) )
            {
            // InternalSolidity.g:918:2: ( () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= 'external' | otherlv_9= 'public' | otherlv_10= 'internal' | otherlv_11= 'private' | otherlv_12= 'constant' )* (otherlv_13= 'returns' ( (lv_returnTypes_14_0= ruleTypeSpecifier ) )* )? (otherlv_15= ';' | ( (lv_block_16_0= ruleBlock ) ) ) )
            // InternalSolidity.g:919:3: () otherlv_1= 'function' ( (lv_name_2_0= RULE_ID ) )? otherlv_3= '(' ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )? otherlv_7= ')' (otherlv_8= 'external' | otherlv_9= 'public' | otherlv_10= 'internal' | otherlv_11= 'private' | otherlv_12= 'constant' )* (otherlv_13= 'returns' ( (lv_returnTypes_14_0= ruleTypeSpecifier ) )* )? (otherlv_15= ';' | ( (lv_block_16_0= ruleBlock ) ) )
            {
            // InternalSolidity.g:919:3: ()
            // InternalSolidity.g:920:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFunctionDefinitionAccess().getFunctionDefinitionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionDefinitionAccess().getFunctionKeyword_1());
              		
            }
            // InternalSolidity.g:930:3: ( (lv_name_2_0= RULE_ID ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSolidity.g:931:4: (lv_name_2_0= RULE_ID )
                    {
                    // InternalSolidity.g:931:4: (lv_name_2_0= RULE_ID )
                    // InternalSolidity.g:932:5: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_name_2_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"name",
                      						lv_name_2_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,28,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionAccess().getLeftParenthesisKeyword_3());
              		
            }
            // InternalSolidity.g:952:3: ( ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSolidity.g:953:4: ( (lv_parameters_4_0= ruleParameter ) ) (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )*
                    {
                    // InternalSolidity.g:953:4: ( (lv_parameters_4_0= ruleParameter ) )
                    // InternalSolidity.g:954:5: (lv_parameters_4_0= ruleParameter )
                    {
                    // InternalSolidity.g:954:5: (lv_parameters_4_0= ruleParameter )
                    // InternalSolidity.g:955:6: lv_parameters_4_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParameterParserRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_21);
                    lv_parameters_4_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_4_0,
                      							"com.yakindu.solidity.Solidity.Parameter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSolidity.g:972:4: (otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==23) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalSolidity.g:973:5: otherlv_5= ',' ( (lv_parameters_6_0= ruleParameter ) )
                    	    {
                    	    otherlv_5=(Token)match(input,23,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionAccess().getCommaKeyword_4_1_0());
                    	      				
                    	    }
                    	    // InternalSolidity.g:977:5: ( (lv_parameters_6_0= ruleParameter ) )
                    	    // InternalSolidity.g:978:6: (lv_parameters_6_0= ruleParameter )
                    	    {
                    	    // InternalSolidity.g:978:6: (lv_parameters_6_0= ruleParameter )
                    	    // InternalSolidity.g:979:7: lv_parameters_6_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParametersParameterParserRuleCall_4_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_21);
                    	    lv_parameters_6_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_6_0,
                    	      								"com.yakindu.solidity.Solidity.Parameter");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,29,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getFunctionDefinitionAccess().getRightParenthesisKeyword_5());
              		
            }
            // InternalSolidity.g:1002:3: (otherlv_8= 'external' | otherlv_9= 'public' | otherlv_10= 'internal' | otherlv_11= 'private' | otherlv_12= 'constant' )*
            loop18:
            do {
                int alt18=6;
                switch ( input.LA(1) ) {
                case 32:
                    {
                    alt18=1;
                    }
                    break;
                case 33:
                    {
                    alt18=2;
                    }
                    break;
                case 34:
                    {
                    alt18=3;
                    }
                    break;
                case 35:
                    {
                    alt18=4;
                    }
                    break;
                case 36:
                    {
                    alt18=5;
                    }
                    break;

                }

                switch (alt18) {
            	case 1 :
            	    // InternalSolidity.g:1003:4: otherlv_8= 'external'
            	    {
            	    otherlv_8=(Token)match(input,32,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_8, grammarAccess.getFunctionDefinitionAccess().getExternalKeyword_6_0());
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // InternalSolidity.g:1008:4: otherlv_9= 'public'
            	    {
            	    otherlv_9=(Token)match(input,33,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_9, grammarAccess.getFunctionDefinitionAccess().getPublicKeyword_6_1());
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // InternalSolidity.g:1013:4: otherlv_10= 'internal'
            	    {
            	    otherlv_10=(Token)match(input,34,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_10, grammarAccess.getFunctionDefinitionAccess().getInternalKeyword_6_2());
            	      			
            	    }

            	    }
            	    break;
            	case 4 :
            	    // InternalSolidity.g:1018:4: otherlv_11= 'private'
            	    {
            	    otherlv_11=(Token)match(input,35,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_11, grammarAccess.getFunctionDefinitionAccess().getPrivateKeyword_6_3());
            	      			
            	    }

            	    }
            	    break;
            	case 5 :
            	    // InternalSolidity.g:1023:4: otherlv_12= 'constant'
            	    {
            	    otherlv_12=(Token)match(input,36,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_12, grammarAccess.getFunctionDefinitionAccess().getConstantKeyword_6_4());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // InternalSolidity.g:1028:3: (otherlv_13= 'returns' ( (lv_returnTypes_14_0= ruleTypeSpecifier ) )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==37) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalSolidity.g:1029:4: otherlv_13= 'returns' ( (lv_returnTypes_14_0= ruleTypeSpecifier ) )*
                    {
                    otherlv_13=(Token)match(input,37,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getFunctionDefinitionAccess().getReturnsKeyword_7_0());
                      			
                    }
                    // InternalSolidity.g:1033:4: ( (lv_returnTypes_14_0= ruleTypeSpecifier ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalSolidity.g:1034:5: (lv_returnTypes_14_0= ruleTypeSpecifier )
                    	    {
                    	    // InternalSolidity.g:1034:5: (lv_returnTypes_14_0= ruleTypeSpecifier )
                    	    // InternalSolidity.g:1035:6: lv_returnTypes_14_0= ruleTypeSpecifier
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getReturnTypesTypeSpecifierParserRuleCall_7_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_26);
                    	    lv_returnTypes_14_0=ruleTypeSpecifier();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"returnTypes",
                    	      							lv_returnTypes_14_0,
                    	      							"org.yakindu.base.expressions.Expressions.TypeSpecifier");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalSolidity.g:1053:3: (otherlv_15= ';' | ( (lv_block_16_0= ruleBlock ) ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            else if ( (LA21_0==24) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalSolidity.g:1054:4: otherlv_15= ';'
                    {
                    otherlv_15=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getFunctionDefinitionAccess().getSemicolonKeyword_8_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:1059:4: ( (lv_block_16_0= ruleBlock ) )
                    {
                    // InternalSolidity.g:1059:4: ( (lv_block_16_0= ruleBlock ) )
                    // InternalSolidity.g:1060:5: (lv_block_16_0= ruleBlock )
                    {
                    // InternalSolidity.g:1060:5: (lv_block_16_0= ruleBlock )
                    // InternalSolidity.g:1061:6: lv_block_16_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getBlockBlockParserRuleCall_8_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_16_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_16_0,
                      							"com.yakindu.solidity.Solidity.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDefinition"


    // $ANTLR start "entryRuleParameter"
    // InternalSolidity.g:1083:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalSolidity.g:1083:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalSolidity.g:1084:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalSolidity.g:1090:1: ruleParameter returns [EObject current=null] : ( ( (lv_typeSpecifier_0_0= ruleTypeSpecifier ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_typeSpecifier_0_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1096:2: ( ( ( (lv_typeSpecifier_0_0= ruleTypeSpecifier ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSolidity.g:1097:2: ( ( (lv_typeSpecifier_0_0= ruleTypeSpecifier ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSolidity.g:1097:2: ( ( (lv_typeSpecifier_0_0= ruleTypeSpecifier ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSolidity.g:1098:3: ( (lv_typeSpecifier_0_0= ruleTypeSpecifier ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSolidity.g:1098:3: ( (lv_typeSpecifier_0_0= ruleTypeSpecifier ) )
            // InternalSolidity.g:1099:4: (lv_typeSpecifier_0_0= ruleTypeSpecifier )
            {
            // InternalSolidity.g:1099:4: (lv_typeSpecifier_0_0= ruleTypeSpecifier )
            // InternalSolidity.g:1100:5: lv_typeSpecifier_0_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getTypeSpecifierTypeSpecifierParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_typeSpecifier_0_0=ruleTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterRule());
              					}
              					set(
              						current,
              						"typeSpecifier",
              						lv_typeSpecifier_0_0,
              						"org.yakindu.base.expressions.Expressions.TypeSpecifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSolidity.g:1117:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSolidity.g:1118:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSolidity.g:1118:4: (lv_name_1_0= RULE_ID )
            // InternalSolidity.g:1119:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getParameterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleEventDefinition"
    // InternalSolidity.g:1139:1: entryRuleEventDefinition returns [EObject current=null] : iv_ruleEventDefinition= ruleEventDefinition EOF ;
    public final EObject entryRuleEventDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDefinition = null;


        try {
            // InternalSolidity.g:1139:56: (iv_ruleEventDefinition= ruleEventDefinition EOF )
            // InternalSolidity.g:1140:2: iv_ruleEventDefinition= ruleEventDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEventDefinition=ruleEventDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEventDefinition"


    // $ANTLR start "ruleEventDefinition"
    // InternalSolidity.g:1146:1: ruleEventDefinition returns [EObject current=null] : (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEventDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:1152:2: ( (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSolidity.g:1153:2: (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSolidity.g:1153:2: (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSolidity.g:1154:3: otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEventDefinitionAccess().getEventKeyword_0());
              		
            }
            // InternalSolidity.g:1158:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSolidity.g:1159:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSolidity.g:1159:4: (lv_name_1_0= RULE_ID )
            // InternalSolidity.g:1160:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getEventDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEventDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEventDefinition"


    // $ANTLR start "entryRuleExpression"
    // InternalSolidity.g:1180:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSolidity.g:1180:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSolidity.g:1181:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalSolidity.g:1187:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1193:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalSolidity.g:1194:2: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AssignmentExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalSolidity.g:1205:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalSolidity.g:1205:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalSolidity.g:1206:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalSolidity.g:1212:1: ruleAssignmentExpression returns [EObject current=null] : (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1218:2: ( (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* ) )
            // InternalSolidity.g:1219:2: (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* )
            {
            // InternalSolidity.g:1219:2: (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* )
            // InternalSolidity.g:1220:3: this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getConditionalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_27);
            this_ConditionalExpression_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ConditionalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1228:3: ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==26||(LA22_0>=56 && LA22_0<=65)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalSolidity.g:1229:4: () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) )
            	    {
            	    // InternalSolidity.g:1229:4: ()
            	    // InternalSolidity.g:1230:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalSolidity.g:1236:4: ( (lv_operator_2_0= ruleAssignmentOperator ) )
            	    // InternalSolidity.g:1237:5: (lv_operator_2_0= ruleAssignmentOperator )
            	    {
            	    // InternalSolidity.g:1237:5: (lv_operator_2_0= ruleAssignmentOperator )
            	    // InternalSolidity.g:1238:6: lv_operator_2_0= ruleAssignmentOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
            	    lv_operator_2_0=ruleAssignmentOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operator",
            	      							lv_operator_2_0,
            	      							"org.yakindu.base.expressions.Expressions.AssignmentOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalSolidity.g:1255:4: ( (lv_expression_3_0= ruleConditionalExpression ) )
            	    // InternalSolidity.g:1256:5: (lv_expression_3_0= ruleConditionalExpression )
            	    {
            	    // InternalSolidity.g:1256:5: (lv_expression_3_0= ruleConditionalExpression )
            	    // InternalSolidity.g:1257:6: lv_expression_3_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getExpressionConditionalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
            	    lv_expression_3_0=ruleConditionalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"expression",
            	      							lv_expression_3_0,
            	      							"org.yakindu.base.expressions.Expressions.ConditionalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleConditionalExpression"
    // InternalSolidity.g:1279:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalSolidity.g:1279:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalSolidity.g:1280:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConditionalExpression=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalExpression"


    // $ANTLR start "ruleConditionalExpression"
    // InternalSolidity.g:1286:1: ruleConditionalExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_trueCase_3_0 = null;

        EObject lv_falseCase_5_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1292:2: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? ) )
            // InternalSolidity.g:1293:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? )
            {
            // InternalSolidity.g:1293:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? )
            // InternalSolidity.g:1294:3: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_28);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1302:3: ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==39) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalSolidity.g:1303:4: () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) )
                    {
                    // InternalSolidity.g:1303:4: ()
                    // InternalSolidity.g:1304:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,39,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1());
                      			
                    }
                    // InternalSolidity.g:1314:4: ( (lv_trueCase_3_0= ruleLogicalOrExpression ) )
                    // InternalSolidity.g:1315:5: (lv_trueCase_3_0= ruleLogicalOrExpression )
                    {
                    // InternalSolidity.g:1315:5: (lv_trueCase_3_0= ruleLogicalOrExpression )
                    // InternalSolidity.g:1316:6: lv_trueCase_3_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getTrueCaseLogicalOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_29);
                    lv_trueCase_3_0=ruleLogicalOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      						}
                      						set(
                      							current,
                      							"trueCase",
                      							lv_trueCase_3_0,
                      							"org.yakindu.base.expressions.Expressions.LogicalOrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,40,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                      			
                    }
                    // InternalSolidity.g:1337:4: ( (lv_falseCase_5_0= ruleLogicalOrExpression ) )
                    // InternalSolidity.g:1338:5: (lv_falseCase_5_0= ruleLogicalOrExpression )
                    {
                    // InternalSolidity.g:1338:5: (lv_falseCase_5_0= ruleLogicalOrExpression )
                    // InternalSolidity.g:1339:6: lv_falseCase_5_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getFalseCaseLogicalOrExpressionParserRuleCall_1_4_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_falseCase_5_0=ruleLogicalOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getConditionalExpressionRule());
                      						}
                      						set(
                      							current,
                      							"falseCase",
                      							lv_falseCase_5_0,
                      							"org.yakindu.base.expressions.Expressions.LogicalOrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalSolidity.g:1361:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalSolidity.g:1361:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalSolidity.g:1362:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // InternalSolidity.g:1368:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1374:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalSolidity.g:1375:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalSolidity.g:1375:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalSolidity.g:1376:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_30);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1384:3: ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==48) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalSolidity.g:1385:4: () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalSolidity.g:1385:4: ()
            	    // InternalSolidity.g:1386:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrOperatorParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_17);
            	    ruleLogicalOrOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalSolidity.g:1399:4: ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    // InternalSolidity.g:1400:5: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalSolidity.g:1400:5: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    // InternalSolidity.g:1401:6: lv_rightOperand_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_30);
            	    lv_rightOperand_3_0=ruleLogicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.yakindu.base.expressions.Expressions.LogicalAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalSolidity.g:1423:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalSolidity.g:1423:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalSolidity.g:1424:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // InternalSolidity.g:1430:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalNotExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1436:2: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) )
            // InternalSolidity.g:1437:2: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            {
            // InternalSolidity.g:1437:2: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            // InternalSolidity.g:1438:3: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalNotExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1446:3: ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==47) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSolidity.g:1447:4: () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    {
            	    // InternalSolidity.g:1447:4: ()
            	    // InternalSolidity.g:1448:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndOperatorParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_17);
            	    ruleLogicalAndOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalSolidity.g:1461:4: ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    // InternalSolidity.g:1462:5: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    {
            	    // InternalSolidity.g:1462:5: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    // InternalSolidity.g:1463:6: lv_rightOperand_3_0= ruleLogicalNotExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
            	    lv_rightOperand_3_0=ruleLogicalNotExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.yakindu.base.expressions.Expressions.LogicalNotExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleLogicalNotExpression"
    // InternalSolidity.g:1485:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // InternalSolidity.g:1485:61: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // InternalSolidity.g:1486:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalNotExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalNotExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalNotExpression"


    // $ANTLR start "ruleLogicalNotExpression"
    // InternalSolidity.g:1492:1: ruleLogicalNotExpression returns [EObject current=null] : (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BitwiseXorExpression_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1498:2: ( (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) ) )
            // InternalSolidity.g:1499:2: (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) )
            {
            // InternalSolidity.g:1499:2: (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_STRING && LA26_0<=RULE_BINARY)||LA26_0==28||LA26_0==30||LA26_0==46||(LA26_0>=68 && LA26_0<=69)||LA26_0==73) ) {
                alt26=1;
            }
            else if ( (LA26_0==49) ) {
                alt26=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // InternalSolidity.g:1500:3: this_BitwiseXorExpression_0= ruleBitwiseXorExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getBitwiseXorExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BitwiseXorExpression_0=ruleBitwiseXorExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BitwiseXorExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:1509:3: ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) )
                    {
                    // InternalSolidity.g:1509:3: ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) )
                    // InternalSolidity.g:1510:4: () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) )
                    {
                    // InternalSolidity.g:1510:4: ()
                    // InternalSolidity.g:1511:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getLogicalNotOperatorParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_32);
                    ruleLogicalNotOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalSolidity.g:1524:4: ( (lv_operand_3_0= ruleBitwiseXorExpression ) )
                    // InternalSolidity.g:1525:5: (lv_operand_3_0= ruleBitwiseXorExpression )
                    {
                    // InternalSolidity.g:1525:5: (lv_operand_3_0= ruleBitwiseXorExpression )
                    // InternalSolidity.g:1526:6: lv_operand_3_0= ruleBitwiseXorExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandBitwiseXorExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_3_0=ruleBitwiseXorExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLogicalNotExpressionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"org.yakindu.base.expressions.Expressions.BitwiseXorExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalNotExpression"


    // $ANTLR start "entryRuleBitwiseXorExpression"
    // InternalSolidity.g:1548:1: entryRuleBitwiseXorExpression returns [EObject current=null] : iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF ;
    public final EObject entryRuleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseXorExpression = null;


        try {
            // InternalSolidity.g:1548:61: (iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF )
            // InternalSolidity.g:1549:2: iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseXorExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitwiseXorExpression=ruleBitwiseXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseXorExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseXorExpression"


    // $ANTLR start "ruleBitwiseXorExpression"
    // InternalSolidity.g:1555:1: ruleBitwiseXorExpression returns [EObject current=null] : (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* ) ;
    public final EObject ruleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BitwiseOrExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1561:2: ( (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* ) )
            // InternalSolidity.g:1562:2: (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* )
            {
            // InternalSolidity.g:1562:2: (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* )
            // InternalSolidity.g:1563:3: this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_33);
            this_BitwiseOrExpression_0=ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitwiseOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1571:3: ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==50) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalSolidity.g:1572:4: () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) )
            	    {
            	    // InternalSolidity.g:1572:4: ()
            	    // InternalSolidity.g:1573:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXorExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseXOrOperatorParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_32);
            	    ruleBitwiseXOrOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalSolidity.g:1586:4: ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) )
            	    // InternalSolidity.g:1587:5: (lv_rightOperand_3_0= ruleBitwiseOrExpression )
            	    {
            	    // InternalSolidity.g:1587:5: (lv_rightOperand_3_0= ruleBitwiseOrExpression )
            	    // InternalSolidity.g:1588:6: lv_rightOperand_3_0= ruleBitwiseOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandBitwiseOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_rightOperand_3_0=ruleBitwiseOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitwiseXorExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.yakindu.base.expressions.Expressions.BitwiseOrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseXorExpression"


    // $ANTLR start "entryRuleBitwiseOrExpression"
    // InternalSolidity.g:1610:1: entryRuleBitwiseOrExpression returns [EObject current=null] : iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF ;
    public final EObject entryRuleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseOrExpression = null;


        try {
            // InternalSolidity.g:1610:60: (iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF )
            // InternalSolidity.g:1611:2: iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitwiseOrExpression=ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseOrExpression"


    // $ANTLR start "ruleBitwiseOrExpression"
    // InternalSolidity.g:1617:1: ruleBitwiseOrExpression returns [EObject current=null] : (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* ) ;
    public final EObject ruleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BitwiseAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1623:2: ( (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* ) )
            // InternalSolidity.g:1624:2: (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* )
            {
            // InternalSolidity.g:1624:2: (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* )
            // InternalSolidity.g:1625:3: this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_34);
            this_BitwiseAndExpression_0=ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitwiseAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1633:3: ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==51) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalSolidity.g:1634:4: () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) )
            	    {
            	    // InternalSolidity.g:1634:4: ()
            	    // InternalSolidity.g:1635:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseOrOperatorParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_32);
            	    ruleBitwiseOrOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalSolidity.g:1648:4: ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) )
            	    // InternalSolidity.g:1649:5: (lv_rightOperand_3_0= ruleBitwiseAndExpression )
            	    {
            	    // InternalSolidity.g:1649:5: (lv_rightOperand_3_0= ruleBitwiseAndExpression )
            	    // InternalSolidity.g:1650:6: lv_rightOperand_3_0= ruleBitwiseAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandBitwiseAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_rightOperand_3_0=ruleBitwiseAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitwiseOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.yakindu.base.expressions.Expressions.BitwiseAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseOrExpression"


    // $ANTLR start "entryRuleBitwiseAndExpression"
    // InternalSolidity.g:1672:1: entryRuleBitwiseAndExpression returns [EObject current=null] : iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF ;
    public final EObject entryRuleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseAndExpression = null;


        try {
            // InternalSolidity.g:1672:61: (iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF )
            // InternalSolidity.g:1673:2: iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitwiseAndExpression=ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseAndExpression"


    // $ANTLR start "ruleBitwiseAndExpression"
    // InternalSolidity.g:1679:1: ruleBitwiseAndExpression returns [EObject current=null] : (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* ) ;
    public final EObject ruleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalRelationExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1685:2: ( (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* ) )
            // InternalSolidity.g:1686:2: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* )
            {
            // InternalSolidity.g:1686:2: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* )
            // InternalSolidity.g:1687:3: this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getLogicalRelationExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_35);
            this_LogicalRelationExpression_0=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalRelationExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1695:3: ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==52) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalSolidity.g:1696:4: () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) )
            	    {
            	    // InternalSolidity.g:1696:4: ()
            	    // InternalSolidity.g:1697:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getBitwiseAndOperatorParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_32);
            	    ruleBitwiseAndOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalSolidity.g:1710:4: ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) )
            	    // InternalSolidity.g:1711:5: (lv_rightOperand_3_0= ruleLogicalRelationExpression )
            	    {
            	    // InternalSolidity.g:1711:5: (lv_rightOperand_3_0= ruleLogicalRelationExpression )
            	    // InternalSolidity.g:1712:6: lv_rightOperand_3_0= ruleLogicalRelationExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandLogicalRelationExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_rightOperand_3_0=ruleLogicalRelationExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitwiseAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.yakindu.base.expressions.Expressions.LogicalRelationExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseAndExpression"


    // $ANTLR start "entryRuleLogicalRelationExpression"
    // InternalSolidity.g:1734:1: entryRuleLogicalRelationExpression returns [EObject current=null] : iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF ;
    public final EObject entryRuleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalRelationExpression = null;


        try {
            // InternalSolidity.g:1734:66: (iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF )
            // InternalSolidity.g:1735:2: iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalRelationExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalRelationExpression=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalRelationExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalRelationExpression"


    // $ANTLR start "ruleLogicalRelationExpression"
    // InternalSolidity.g:1741:1: ruleLogicalRelationExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1747:2: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* ) )
            // InternalSolidity.g:1748:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* )
            {
            // InternalSolidity.g:1748:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* )
            // InternalSolidity.g:1749:3: this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_36);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1757:3: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=44 && LA30_0<=45)||(LA30_0>=74 && LA30_0<=77)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalSolidity.g:1758:4: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalSolidity.g:1758:4: ()
            	    // InternalSolidity.g:1759:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalSolidity.g:1765:4: ( (lv_operator_2_0= ruleRelationalOperator ) )
            	    // InternalSolidity.g:1766:5: (lv_operator_2_0= ruleRelationalOperator )
            	    {
            	    // InternalSolidity.g:1766:5: (lv_operator_2_0= ruleRelationalOperator )
            	    // InternalSolidity.g:1767:6: lv_operator_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_operator_2_0=ruleRelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalRelationExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operator",
            	      							lv_operator_2_0,
            	      							"org.yakindu.base.expressions.Expressions.RelationalOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalSolidity.g:1784:4: ( (lv_rightOperand_3_0= ruleShiftExpression ) )
            	    // InternalSolidity.g:1785:5: (lv_rightOperand_3_0= ruleShiftExpression )
            	    {
            	    // InternalSolidity.g:1785:5: (lv_rightOperand_3_0= ruleShiftExpression )
            	    // InternalSolidity.g:1786:6: lv_rightOperand_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandShiftExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_rightOperand_3_0=ruleShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalRelationExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.yakindu.base.expressions.Expressions.ShiftExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalRelationExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalSolidity.g:1808:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalSolidity.g:1808:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalSolidity.g:1809:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // InternalSolidity.g:1815:1: ruleShiftExpression returns [EObject current=null] : (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalAddSubtractExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1821:2: ( (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) )
            // InternalSolidity.g:1822:2: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            {
            // InternalSolidity.g:1822:2: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            // InternalSolidity.g:1823:3: this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_37);
            this_NumericalAddSubtractExpression_0=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_NumericalAddSubtractExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1831:3: ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=66 && LA31_0<=67)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalSolidity.g:1832:4: () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    {
            	    // InternalSolidity.g:1832:4: ()
            	    // InternalSolidity.g:1833:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalSolidity.g:1839:4: ( (lv_operator_2_0= ruleShiftOperator ) )
            	    // InternalSolidity.g:1840:5: (lv_operator_2_0= ruleShiftOperator )
            	    {
            	    // InternalSolidity.g:1840:5: (lv_operator_2_0= ruleShiftOperator )
            	    // InternalSolidity.g:1841:6: lv_operator_2_0= ruleShiftOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_operator_2_0=ruleShiftOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"operator",
            	      							lv_operator_2_0,
            	      							"org.yakindu.base.expressions.Expressions.ShiftOperator");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalSolidity.g:1858:4: ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    // InternalSolidity.g:1859:5: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    {
            	    // InternalSolidity.g:1859:5: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    // InternalSolidity.g:1860:6: lv_rightOperand_3_0= ruleNumericalAddSubtractExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_rightOperand_3_0=ruleNumericalAddSubtractExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"org.yakindu.base.expressions.Expressions.NumericalAddSubtractExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleNumericalAddSubtractExpression"
    // InternalSolidity.g:1882:1: entryRuleNumericalAddSubtractExpression returns [EObject current=null] : iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF ;
    public final EObject entryRuleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalAddSubtractExpression = null;


        try {
            // InternalSolidity.g:1882:71: (iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF )
            // InternalSolidity.g:1883:2: iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumericalAddSubtractExpression=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalAddSubtractExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericalAddSubtractExpression"


    // $ANTLR start "ruleNumericalAddSubtractExpression"
    // InternalSolidity.g:1889:1: ruleNumericalAddSubtractExpression returns [EObject current=null] : (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )* ) ;
    public final EObject ruleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalMultiplyDivideExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1895:2: ( (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )* ) )
            // InternalSolidity.g:1896:2: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )* )
            {
            // InternalSolidity.g:1896:2: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )* )
            // InternalSolidity.g:1897:3: this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_38);
            this_NumericalMultiplyDivideExpression_0=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_NumericalMultiplyDivideExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1905:3: ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==68) && (synpred1_InternalSolidity())) {
                    alt32=1;
                }
                else if ( (LA32_0==69) && (synpred1_InternalSolidity())) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalSolidity.g:1906:4: ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )
            	    {
            	    // InternalSolidity.g:1921:4: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )
            	    // InternalSolidity.g:1922:5: () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    {
            	    // InternalSolidity.g:1922:5: ()
            	    // InternalSolidity.g:1923:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalSolidity.g:1929:5: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // InternalSolidity.g:1930:6: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // InternalSolidity.g:1930:6: (lv_operator_2_0= ruleAdditiveOperator )
            	    // InternalSolidity.g:1931:7: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_operator_2_0=ruleAdditiveOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getNumericalAddSubtractExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"operator",
            	      								lv_operator_2_0,
            	      								"org.yakindu.base.expressions.Expressions.AdditiveOperator");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalSolidity.g:1948:5: ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    // InternalSolidity.g:1949:6: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    {
            	    // InternalSolidity.g:1949:6: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    // InternalSolidity.g:1950:7: lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_rightOperand_3_0=ruleNumericalMultiplyDivideExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getNumericalAddSubtractExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rightOperand",
            	      								lv_rightOperand_3_0,
            	      								"org.yakindu.base.expressions.Expressions.NumericalMultiplyDivideExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericalAddSubtractExpression"


    // $ANTLR start "entryRuleNumericalMultiplyDivideExpression"
    // InternalSolidity.g:1973:1: entryRuleNumericalMultiplyDivideExpression returns [EObject current=null] : iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF ;
    public final EObject entryRuleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalMultiplyDivideExpression = null;


        try {
            // InternalSolidity.g:1973:74: (iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF )
            // InternalSolidity.g:1974:2: iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumericalMultiplyDivideExpression=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalMultiplyDivideExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericalMultiplyDivideExpression"


    // $ANTLR start "ruleNumericalMultiplyDivideExpression"
    // InternalSolidity.g:1980:1: ruleNumericalMultiplyDivideExpression returns [EObject current=null] : (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )* ) ;
    public final EObject ruleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalUnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1986:2: ( (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )* ) )
            // InternalSolidity.g:1987:2: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )* )
            {
            // InternalSolidity.g:1987:2: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )* )
            // InternalSolidity.g:1988:3: this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_39);
            this_NumericalUnaryExpression_0=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_NumericalUnaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1996:3: ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==70) && (synpred2_InternalSolidity())) {
                    alt33=1;
                }
                else if ( (LA33_0==71) && (synpred2_InternalSolidity())) {
                    alt33=1;
                }
                else if ( (LA33_0==72) && (synpred2_InternalSolidity())) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalSolidity.g:1997:4: ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )
            	    {
            	    // InternalSolidity.g:2012:4: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )
            	    // InternalSolidity.g:2013:5: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    {
            	    // InternalSolidity.g:2013:5: ()
            	    // InternalSolidity.g:2014:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalSolidity.g:2020:5: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // InternalSolidity.g:2021:6: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // InternalSolidity.g:2021:6: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // InternalSolidity.g:2022:7: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_operator_2_0=ruleMultiplicativeOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getNumericalMultiplyDivideExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"operator",
            	      								lv_operator_2_0,
            	      								"org.yakindu.base.expressions.Expressions.MultiplicativeOperator");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalSolidity.g:2039:5: ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    // InternalSolidity.g:2040:6: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    {
            	    // InternalSolidity.g:2040:6: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    // InternalSolidity.g:2041:7: lv_rightOperand_3_0= ruleNumericalUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_rightOperand_3_0=ruleNumericalUnaryExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getNumericalMultiplyDivideExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rightOperand",
            	      								lv_rightOperand_3_0,
            	      								"org.yakindu.base.expressions.Expressions.NumericalUnaryExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericalMultiplyDivideExpression"


    // $ANTLR start "entryRuleNumericalUnaryExpression"
    // InternalSolidity.g:2064:1: entryRuleNumericalUnaryExpression returns [EObject current=null] : iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF ;
    public final EObject entryRuleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalUnaryExpression = null;


        try {
            // InternalSolidity.g:2064:65: (iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF )
            // InternalSolidity.g:2065:2: iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumericalUnaryExpression=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericalUnaryExpression"


    // $ANTLR start "ruleNumericalUnaryExpression"
    // InternalSolidity.g:2071:1: ruleNumericalUnaryExpression returns [EObject current=null] : (this_TypeCastExpression_0= ruleTypeCastExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) ) ) ;
    public final EObject ruleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_TypeCastExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2077:2: ( (this_TypeCastExpression_0= ruleTypeCastExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) ) ) )
            // InternalSolidity.g:2078:2: (this_TypeCastExpression_0= ruleTypeCastExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) ) )
            {
            // InternalSolidity.g:2078:2: (this_TypeCastExpression_0= ruleTypeCastExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_STRING && LA34_0<=RULE_BINARY)||LA34_0==28||LA34_0==30||LA34_0==46) ) {
                alt34=1;
            }
            else if ( ((LA34_0>=68 && LA34_0<=69)||LA34_0==73) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalSolidity.g:2079:3: this_TypeCastExpression_0= ruleTypeCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getTypeCastExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeCastExpression_0=ruleTypeCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeCastExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:2088:3: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) )
                    {
                    // InternalSolidity.g:2088:3: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) )
                    // InternalSolidity.g:2089:4: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) )
                    {
                    // InternalSolidity.g:2089:4: ()
                    // InternalSolidity.g:2090:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSolidity.g:2096:4: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // InternalSolidity.g:2097:5: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // InternalSolidity.g:2097:5: (lv_operator_2_0= ruleUnaryOperator )
                    // InternalSolidity.g:2098:6: lv_operator_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
                    lv_operator_2_0=ruleUnaryOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNumericalUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"operator",
                      							lv_operator_2_0,
                      							"org.yakindu.base.expressions.Expressions.UnaryOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSolidity.g:2115:4: ( (lv_operand_3_0= ruleTypeCastExpression ) )
                    // InternalSolidity.g:2116:5: (lv_operand_3_0= ruleTypeCastExpression )
                    {
                    // InternalSolidity.g:2116:5: (lv_operand_3_0= ruleTypeCastExpression )
                    // InternalSolidity.g:2117:6: lv_operand_3_0= ruleTypeCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperandTypeCastExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_3_0=ruleTypeCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNumericalUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"org.yakindu.base.expressions.Expressions.TypeCastExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericalUnaryExpression"


    // $ANTLR start "entryRuleTypeCastExpression"
    // InternalSolidity.g:2139:1: entryRuleTypeCastExpression returns [EObject current=null] : iv_ruleTypeCastExpression= ruleTypeCastExpression EOF ;
    public final EObject entryRuleTypeCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeCastExpression = null;


        try {
            // InternalSolidity.g:2139:59: (iv_ruleTypeCastExpression= ruleTypeCastExpression EOF )
            // InternalSolidity.g:2140:2: iv_ruleTypeCastExpression= ruleTypeCastExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeCastExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeCastExpression=ruleTypeCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeCastExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeCastExpression"


    // $ANTLR start "ruleTypeCastExpression"
    // InternalSolidity.g:2146:1: ruleTypeCastExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )* ) ;
    public final EObject ruleTypeCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2152:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )* ) )
            // InternalSolidity.g:2153:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )* )
            {
            // InternalSolidity.g:2153:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )* )
            // InternalSolidity.g:2154:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getTypeCastExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_41);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:2162:3: ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==21) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalSolidity.g:2163:4: ( () otherlv_2= 'as' ) ( ( ruleQID ) )
            	    {
            	    // InternalSolidity.g:2163:4: ( () otherlv_2= 'as' )
            	    // InternalSolidity.g:2164:5: () otherlv_2= 'as'
            	    {
            	    // InternalSolidity.g:2164:5: ()
            	    // InternalSolidity.g:2165:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getTypeCastExpressionAccess().getTypeCastExpressionOperandAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_2=(Token)match(input,21,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getTypeCastExpressionAccess().getAsKeyword_1_0_1());
            	      				
            	    }

            	    }

            	    // InternalSolidity.g:2176:4: ( ( ruleQID ) )
            	    // InternalSolidity.g:2177:5: ( ruleQID )
            	    {
            	    // InternalSolidity.g:2177:5: ( ruleQID )
            	    // InternalSolidity.g:2178:6: ruleQID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getTypeCastExpressionRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTypeCastExpressionAccess().getTypeTypeCrossReference_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_41);
            	    ruleQID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeCastExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalSolidity.g:2197:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalSolidity.g:2197:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSolidity.g:2198:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalSolidity.g:2204:1: rulePrimaryExpression returns [EObject current=null] : (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveValueExpression_0 = null;

        EObject this_FeatureCall_1 = null;

        EObject this_ParenthesizedExpression_2 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2210:2: ( (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) )
            // InternalSolidity.g:2211:2: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            {
            // InternalSolidity.g:2211:2: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            int alt36=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_BOOL:
            case RULE_INT:
            case RULE_DOUBLE:
            case RULE_FLOAT:
            case RULE_HEX:
            case RULE_BINARY:
            case 30:
            case 46:
                {
                alt36=1;
                }
                break;
            case RULE_ID:
                {
                alt36=2;
                }
                break;
            case 28:
                {
                alt36=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalSolidity.g:2212:3: this_PrimitiveValueExpression_0= rulePrimitiveValueExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getPrimitiveValueExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PrimitiveValueExpression_0=rulePrimitiveValueExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrimitiveValueExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:2221:3: this_FeatureCall_1= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FeatureCall_1=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FeatureCall_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSolidity.g:2230:3: this_ParenthesizedExpression_2= ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParenthesizedExpression_2=ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParenthesizedExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRulePrimitiveValueExpression"
    // InternalSolidity.g:2242:1: entryRulePrimitiveValueExpression returns [EObject current=null] : iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF ;
    public final EObject entryRulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValueExpression = null;


        try {
            // InternalSolidity.g:2242:65: (iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF )
            // InternalSolidity.g:2243:2: iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveValueExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveValueExpression=rulePrimitiveValueExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveValueExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveValueExpression"


    // $ANTLR start "rulePrimitiveValueExpression"
    // InternalSolidity.g:2249:1: rulePrimitiveValueExpression returns [EObject current=null] : ( () ( (lv_value_1_0= ruleLiteral ) ) ) ;
    public final EObject rulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2255:2: ( ( () ( (lv_value_1_0= ruleLiteral ) ) ) )
            // InternalSolidity.g:2256:2: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            {
            // InternalSolidity.g:2256:2: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            // InternalSolidity.g:2257:3: () ( (lv_value_1_0= ruleLiteral ) )
            {
            // InternalSolidity.g:2257:3: ()
            // InternalSolidity.g:2258:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:2264:3: ( (lv_value_1_0= ruleLiteral ) )
            // InternalSolidity.g:2265:4: (lv_value_1_0= ruleLiteral )
            {
            // InternalSolidity.g:2265:4: (lv_value_1_0= ruleLiteral )
            // InternalSolidity.g:2266:5: lv_value_1_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPrimitiveValueExpressionAccess().getValueLiteralParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPrimitiveValueExpressionRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"com.yakindu.solidity.Solidity.Literal");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveValueExpression"


    // $ANTLR start "entryRuleFeatureCall"
    // InternalSolidity.g:2287:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // InternalSolidity.g:2287:52: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalSolidity.g:2288:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // InternalSolidity.g:2294:1: ruleFeatureCall returns [EObject current=null] : (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_operationCall_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_arrayAccess_9_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject this_ElementReferenceExpression_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_arguments_7_0 = null;

        EObject lv_arraySelector_10_0 = null;

        EObject lv_arraySelector_13_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2300:2: ( (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* ) )
            // InternalSolidity.g:2301:2: (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* )
            {
            // InternalSolidity.g:2301:2: (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* )
            // InternalSolidity.g:2302:3: this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getFeatureCallAccess().getElementReferenceExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_42);
            this_ElementReferenceExpression_0=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ElementReferenceExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:2310:3: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==41) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalSolidity.g:2311:4: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )?
            	    {
            	    // InternalSolidity.g:2311:4: ()
            	    // InternalSolidity.g:2312:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getFeatureCallAccess().getFeatureCallOwnerAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,41,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_1());
            	      			
            	    }
            	    // InternalSolidity.g:2322:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalSolidity.g:2323:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalSolidity.g:2323:5: (otherlv_3= RULE_ID )
            	    // InternalSolidity.g:2324:6: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getFeatureCallRule());
            	      						}
            	      					
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_43); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_3, grammarAccess.getFeatureCallAccess().getFeatureEObjectCrossReference_1_2_0());
            	      					
            	    }

            	    }


            	    }

            	    // InternalSolidity.g:2335:4: ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )?
            	    int alt40=3;
            	    int LA40_0 = input.LA(1);

            	    if ( (LA40_0==28) && (synpred3_InternalSolidity())) {
            	        alt40=1;
            	    }
            	    else if ( (LA40_0==42) && (synpred4_InternalSolidity())) {
            	        alt40=2;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // InternalSolidity.g:2336:5: ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' )
            	            {
            	            // InternalSolidity.g:2336:5: ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' )
            	            // InternalSolidity.g:2337:6: ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')'
            	            {
            	            // InternalSolidity.g:2337:6: ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) )
            	            // InternalSolidity.g:2338:7: ( ( '(' ) )=> (lv_operationCall_4_0= '(' )
            	            {
            	            // InternalSolidity.g:2342:7: (lv_operationCall_4_0= '(' )
            	            // InternalSolidity.g:2343:8: lv_operationCall_4_0= '('
            	            {
            	            lv_operationCall_4_0=(Token)match(input,28,FOLLOW_44); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_operationCall_4_0, grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_3_0_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getFeatureCallRule());
            	              								}
            	              								setWithLastConsumed(current, "operationCall", true, "(");
            	              							
            	            }

            	            }


            	            }

            	            // InternalSolidity.g:2355:6: ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )?
            	            int alt38=2;
            	            int LA38_0 = input.LA(1);

            	            if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_BINARY)||LA38_0==28||LA38_0==30||LA38_0==46||LA38_0==49||(LA38_0>=68 && LA38_0<=69)||LA38_0==73) ) {
            	                alt38=1;
            	            }
            	            switch (alt38) {
            	                case 1 :
            	                    // InternalSolidity.g:2356:7: ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )*
            	                    {
            	                    // InternalSolidity.g:2356:7: ( (lv_arguments_5_0= ruleArgument ) )
            	                    // InternalSolidity.g:2357:8: (lv_arguments_5_0= ruleArgument )
            	                    {
            	                    // InternalSolidity.g:2357:8: (lv_arguments_5_0= ruleArgument )
            	                    // InternalSolidity.g:2358:9: lv_arguments_5_0= ruleArgument
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									newCompositeNode(grammarAccess.getFeatureCallAccess().getArgumentsArgumentParserRuleCall_1_3_0_1_0_0());
            	                      								
            	                    }
            	                    pushFollow(FOLLOW_21);
            	                    lv_arguments_5_0=ruleArgument();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      									if (current==null) {
            	                      										current = createModelElementForParent(grammarAccess.getFeatureCallRule());
            	                      									}
            	                      									add(
            	                      										current,
            	                      										"arguments",
            	                      										lv_arguments_5_0,
            	                      										"org.yakindu.base.expressions.Expressions.Argument");
            	                      									afterParserOrEnumRuleCall();
            	                      								
            	                    }

            	                    }


            	                    }

            	                    // InternalSolidity.g:2375:7: (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )*
            	                    loop37:
            	                    do {
            	                        int alt37=2;
            	                        int LA37_0 = input.LA(1);

            	                        if ( (LA37_0==23) ) {
            	                            alt37=1;
            	                        }


            	                        switch (alt37) {
            	                    	case 1 :
            	                    	    // InternalSolidity.g:2376:8: otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) )
            	                    	    {
            	                    	    otherlv_6=(Token)match(input,23,FOLLOW_17); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      								newLeafNode(otherlv_6, grammarAccess.getFeatureCallAccess().getCommaKeyword_1_3_0_1_1_0());
            	                    	      							
            	                    	    }
            	                    	    // InternalSolidity.g:2380:8: ( (lv_arguments_7_0= ruleArgument ) )
            	                    	    // InternalSolidity.g:2381:9: (lv_arguments_7_0= ruleArgument )
            	                    	    {
            	                    	    // InternalSolidity.g:2381:9: (lv_arguments_7_0= ruleArgument )
            	                    	    // InternalSolidity.g:2382:10: lv_arguments_7_0= ruleArgument
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      										newCompositeNode(grammarAccess.getFeatureCallAccess().getArgumentsArgumentParserRuleCall_1_3_0_1_1_1_0());
            	                    	      									
            	                    	    }
            	                    	    pushFollow(FOLLOW_21);
            	                    	    lv_arguments_7_0=ruleArgument();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      										if (current==null) {
            	                    	      											current = createModelElementForParent(grammarAccess.getFeatureCallRule());
            	                    	      										}
            	                    	      										add(
            	                    	      											current,
            	                    	      											"arguments",
            	                    	      											lv_arguments_7_0,
            	                    	      											"org.yakindu.base.expressions.Expressions.Argument");
            	                    	      										afterParserOrEnumRuleCall();
            	                    	      									
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop37;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_8=(Token)match(input,29,FOLLOW_42); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_8, grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_3_0_2());
            	              					
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSolidity.g:2407:5: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* )
            	            {
            	            // InternalSolidity.g:2407:5: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* )
            	            // InternalSolidity.g:2408:6: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )*
            	            {
            	            // InternalSolidity.g:2408:6: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) )
            	            // InternalSolidity.g:2409:7: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' )
            	            {
            	            // InternalSolidity.g:2423:7: ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' )
            	            // InternalSolidity.g:2424:8: ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']'
            	            {
            	            // InternalSolidity.g:2424:8: ( (lv_arrayAccess_9_0= '[' ) )
            	            // InternalSolidity.g:2425:9: (lv_arrayAccess_9_0= '[' )
            	            {
            	            // InternalSolidity.g:2425:9: (lv_arrayAccess_9_0= '[' )
            	            // InternalSolidity.g:2426:10: lv_arrayAccess_9_0= '['
            	            {
            	            lv_arrayAccess_9_0=(Token)match(input,42,FOLLOW_17); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										newLeafNode(lv_arrayAccess_9_0, grammarAccess.getFeatureCallAccess().getArrayAccessLeftSquareBracketKeyword_1_3_1_0_0_0_0());
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElement(grammarAccess.getFeatureCallRule());
            	              										}
            	              										setWithLastConsumed(current, "arrayAccess", true, "[");
            	              									
            	            }

            	            }


            	            }

            	            // InternalSolidity.g:2438:8: ( (lv_arraySelector_10_0= ruleExpression ) )
            	            // InternalSolidity.g:2439:9: (lv_arraySelector_10_0= ruleExpression )
            	            {
            	            // InternalSolidity.g:2439:9: (lv_arraySelector_10_0= ruleExpression )
            	            // InternalSolidity.g:2440:10: lv_arraySelector_10_0= ruleExpression
            	            {
            	            if ( state.backtracking==0 ) {

            	              										newCompositeNode(grammarAccess.getFeatureCallAccess().getArraySelectorExpressionParserRuleCall_1_3_1_0_0_1_0());
            	              									
            	            }
            	            pushFollow(FOLLOW_45);
            	            lv_arraySelector_10_0=ruleExpression();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElementForParent(grammarAccess.getFeatureCallRule());
            	              										}
            	              										add(
            	              											current,
            	              											"arraySelector",
            	              											lv_arraySelector_10_0,
            	              											"org.yakindu.base.expressions.Expressions.Expression");
            	              										afterParserOrEnumRuleCall();
            	              									
            	            }

            	            }


            	            }

            	            otherlv_11=(Token)match(input,43,FOLLOW_46); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(otherlv_11, grammarAccess.getFeatureCallAccess().getRightSquareBracketKeyword_1_3_1_0_0_2());
            	              							
            	            }

            	            }


            	            }

            	            // InternalSolidity.g:2463:6: ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )*
            	            loop39:
            	            do {
            	                int alt39=2;
            	                int LA39_0 = input.LA(1);

            	                if ( (LA39_0==42) && (synpred5_InternalSolidity())) {
            	                    alt39=1;
            	                }


            	                switch (alt39) {
            	            	case 1 :
            	            	    // InternalSolidity.g:2464:7: ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' )
            	            	    {
            	            	    // InternalSolidity.g:2474:7: (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' )
            	            	    // InternalSolidity.g:2475:8: otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']'
            	            	    {
            	            	    otherlv_12=(Token)match(input,42,FOLLOW_17); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      								newLeafNode(otherlv_12, grammarAccess.getFeatureCallAccess().getLeftSquareBracketKeyword_1_3_1_1_0_0());
            	            	      							
            	            	    }
            	            	    // InternalSolidity.g:2479:8: ( (lv_arraySelector_13_0= ruleExpression ) )
            	            	    // InternalSolidity.g:2480:9: (lv_arraySelector_13_0= ruleExpression )
            	            	    {
            	            	    // InternalSolidity.g:2480:9: (lv_arraySelector_13_0= ruleExpression )
            	            	    // InternalSolidity.g:2481:10: lv_arraySelector_13_0= ruleExpression
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      										newCompositeNode(grammarAccess.getFeatureCallAccess().getArraySelectorExpressionParserRuleCall_1_3_1_1_0_1_0());
            	            	      									
            	            	    }
            	            	    pushFollow(FOLLOW_45);
            	            	    lv_arraySelector_13_0=ruleExpression();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      										if (current==null) {
            	            	      											current = createModelElementForParent(grammarAccess.getFeatureCallRule());
            	            	      										}
            	            	      										add(
            	            	      											current,
            	            	      											"arraySelector",
            	            	      											lv_arraySelector_13_0,
            	            	      											"org.yakindu.base.expressions.Expressions.Expression");
            	            	      										afterParserOrEnumRuleCall();
            	            	      									
            	            	    }

            	            	    }


            	            	    }

            	            	    otherlv_14=(Token)match(input,43,FOLLOW_46); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      								newLeafNode(otherlv_14, grammarAccess.getFeatureCallAccess().getRightSquareBracketKeyword_1_3_1_1_0_2());
            	            	      							
            	            	    }

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop39;
            	                }
            	            } while (true);


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleElementReferenceExpression"
    // InternalSolidity.g:2511:1: entryRuleElementReferenceExpression returns [EObject current=null] : iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF ;
    public final EObject entryRuleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementReferenceExpression = null;


        try {
            // InternalSolidity.g:2511:67: (iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF )
            // InternalSolidity.g:2512:2: iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleElementReferenceExpression=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElementReferenceExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElementReferenceExpression"


    // $ANTLR start "ruleElementReferenceExpression"
    // InternalSolidity.g:2518:1: ruleElementReferenceExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )? ) ;
    public final EObject ruleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_operationCall_2_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_arrayAccess_7_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_arraySelector_8_0 = null;

        EObject lv_arraySelector_11_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2524:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )? ) )
            // InternalSolidity.g:2525:2: ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )? )
            {
            // InternalSolidity.g:2525:2: ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )? )
            // InternalSolidity.g:2526:3: () ( (otherlv_1= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )?
            {
            // InternalSolidity.g:2526:3: ()
            // InternalSolidity.g:2527:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getElementReferenceExpressionAccess().getElementReferenceExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:2533:3: ( (otherlv_1= RULE_ID ) )
            // InternalSolidity.g:2534:4: (otherlv_1= RULE_ID )
            {
            // InternalSolidity.g:2534:4: (otherlv_1= RULE_ID )
            // InternalSolidity.g:2535:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getElementReferenceExpressionAccess().getReferenceEObjectCrossReference_1_0());
              				
            }

            }


            }

            // InternalSolidity.g:2546:3: ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )?
            int alt45=3;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==28) && (synpred6_InternalSolidity())) {
                alt45=1;
            }
            else if ( (LA45_0==42) && (synpred7_InternalSolidity())) {
                alt45=2;
            }
            switch (alt45) {
                case 1 :
                    // InternalSolidity.g:2547:4: ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' )
                    {
                    // InternalSolidity.g:2547:4: ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' )
                    // InternalSolidity.g:2548:5: ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')'
                    {
                    // InternalSolidity.g:2548:5: ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) )
                    // InternalSolidity.g:2549:6: ( ( '(' ) )=> (lv_operationCall_2_0= '(' )
                    {
                    // InternalSolidity.g:2553:6: (lv_operationCall_2_0= '(' )
                    // InternalSolidity.g:2554:7: lv_operationCall_2_0= '('
                    {
                    lv_operationCall_2_0=(Token)match(input,28,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_operationCall_2_0, grammarAccess.getElementReferenceExpressionAccess().getOperationCallLeftParenthesisKeyword_2_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
                      							}
                      							setWithLastConsumed(current, "operationCall", true, "(");
                      						
                    }

                    }


                    }

                    // InternalSolidity.g:2566:5: ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_BINARY)||LA43_0==28||LA43_0==30||LA43_0==46||LA43_0==49||(LA43_0>=68 && LA43_0<=69)||LA43_0==73) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalSolidity.g:2567:6: ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )*
                            {
                            // InternalSolidity.g:2567:6: ( (lv_arguments_3_0= ruleArgument ) )
                            // InternalSolidity.g:2568:7: (lv_arguments_3_0= ruleArgument )
                            {
                            // InternalSolidity.g:2568:7: (lv_arguments_3_0= ruleArgument )
                            // InternalSolidity.g:2569:8: lv_arguments_3_0= ruleArgument
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArgumentsArgumentParserRuleCall_2_0_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_21);
                            lv_arguments_3_0=ruleArgument();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getElementReferenceExpressionRule());
                              								}
                              								add(
                              									current,
                              									"arguments",
                              									lv_arguments_3_0,
                              									"org.yakindu.base.expressions.Expressions.Argument");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalSolidity.g:2586:6: (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )*
                            loop42:
                            do {
                                int alt42=2;
                                int LA42_0 = input.LA(1);

                                if ( (LA42_0==23) ) {
                                    alt42=1;
                                }


                                switch (alt42) {
                            	case 1 :
                            	    // InternalSolidity.g:2587:7: otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) )
                            	    {
                            	    otherlv_4=(Token)match(input,23,FOLLOW_17); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_4, grammarAccess.getElementReferenceExpressionAccess().getCommaKeyword_2_0_1_1_0());
                            	      						
                            	    }
                            	    // InternalSolidity.g:2591:7: ( (lv_arguments_5_0= ruleArgument ) )
                            	    // InternalSolidity.g:2592:8: (lv_arguments_5_0= ruleArgument )
                            	    {
                            	    // InternalSolidity.g:2592:8: (lv_arguments_5_0= ruleArgument )
                            	    // InternalSolidity.g:2593:9: lv_arguments_5_0= ruleArgument
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArgumentsArgumentParserRuleCall_2_0_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_21);
                            	    lv_arguments_5_0=ruleArgument();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getElementReferenceExpressionRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"arguments",
                            	      										lv_arguments_5_0,
                            	      										"org.yakindu.base.expressions.Expressions.Argument");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop42;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getElementReferenceExpressionAccess().getRightParenthesisKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:2618:4: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* )
                    {
                    // InternalSolidity.g:2618:4: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* )
                    // InternalSolidity.g:2619:5: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )*
                    {
                    // InternalSolidity.g:2619:5: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) )
                    // InternalSolidity.g:2620:6: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' )
                    {
                    // InternalSolidity.g:2634:6: ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' )
                    // InternalSolidity.g:2635:7: ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']'
                    {
                    // InternalSolidity.g:2635:7: ( (lv_arrayAccess_7_0= '[' ) )
                    // InternalSolidity.g:2636:8: (lv_arrayAccess_7_0= '[' )
                    {
                    // InternalSolidity.g:2636:8: (lv_arrayAccess_7_0= '[' )
                    // InternalSolidity.g:2637:9: lv_arrayAccess_7_0= '['
                    {
                    lv_arrayAccess_7_0=(Token)match(input,42,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      									newLeafNode(lv_arrayAccess_7_0, grammarAccess.getElementReferenceExpressionAccess().getArrayAccessLeftSquareBracketKeyword_2_1_0_0_0_0());
                      								
                    }
                    if ( state.backtracking==0 ) {

                      									if (current==null) {
                      										current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
                      									}
                      									setWithLastConsumed(current, "arrayAccess", true, "[");
                      								
                    }

                    }


                    }

                    // InternalSolidity.g:2649:7: ( (lv_arraySelector_8_0= ruleExpression ) )
                    // InternalSolidity.g:2650:8: (lv_arraySelector_8_0= ruleExpression )
                    {
                    // InternalSolidity.g:2650:8: (lv_arraySelector_8_0= ruleExpression )
                    // InternalSolidity.g:2651:9: lv_arraySelector_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      									newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArraySelectorExpressionParserRuleCall_2_1_0_0_1_0());
                      								
                    }
                    pushFollow(FOLLOW_45);
                    lv_arraySelector_8_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      									if (current==null) {
                      										current = createModelElementForParent(grammarAccess.getElementReferenceExpressionRule());
                      									}
                      									add(
                      										current,
                      										"arraySelector",
                      										lv_arraySelector_8_0,
                      										"org.yakindu.base.expressions.Expressions.Expression");
                      									afterParserOrEnumRuleCall();
                      								
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,43,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_9, grammarAccess.getElementReferenceExpressionAccess().getRightSquareBracketKeyword_2_1_0_0_2());
                      						
                    }

                    }


                    }

                    // InternalSolidity.g:2674:5: ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==42) && (synpred8_InternalSolidity())) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalSolidity.g:2675:6: ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' )
                    	    {
                    	    // InternalSolidity.g:2685:6: (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' )
                    	    // InternalSolidity.g:2686:7: otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']'
                    	    {
                    	    otherlv_10=(Token)match(input,42,FOLLOW_17); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_10, grammarAccess.getElementReferenceExpressionAccess().getLeftSquareBracketKeyword_2_1_1_0_0());
                    	      						
                    	    }
                    	    // InternalSolidity.g:2690:7: ( (lv_arraySelector_11_0= ruleExpression ) )
                    	    // InternalSolidity.g:2691:8: (lv_arraySelector_11_0= ruleExpression )
                    	    {
                    	    // InternalSolidity.g:2691:8: (lv_arraySelector_11_0= ruleExpression )
                    	    // InternalSolidity.g:2692:9: lv_arraySelector_11_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArraySelectorExpressionParserRuleCall_2_1_1_0_1_0());
                    	      								
                    	    }
                    	    pushFollow(FOLLOW_45);
                    	    lv_arraySelector_11_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      									if (current==null) {
                    	      										current = createModelElementForParent(grammarAccess.getElementReferenceExpressionRule());
                    	      									}
                    	      									add(
                    	      										current,
                    	      										"arraySelector",
                    	      										lv_arraySelector_11_0,
                    	      										"org.yakindu.base.expressions.Expressions.Expression");
                    	      									afterParserOrEnumRuleCall();
                    	      								
                    	    }

                    	    }


                    	    }

                    	    otherlv_12=(Token)match(input,43,FOLLOW_48); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_12, grammarAccess.getElementReferenceExpressionAccess().getRightSquareBracketKeyword_2_1_1_0_2());
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElementReferenceExpression"


    // $ANTLR start "entryRuleArgument"
    // InternalSolidity.g:2721:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalSolidity.g:2721:49: (iv_ruleArgument= ruleArgument EOF )
            // InternalSolidity.g:2722:2: iv_ruleArgument= ruleArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArgument=ruleArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArgument"


    // $ANTLR start "ruleArgument"
    // InternalSolidity.g:2728:1: ruleArgument returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_value_2_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2734:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_value_2_0= ruleConditionalExpression ) ) ) )
            // InternalSolidity.g:2735:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_value_2_0= ruleConditionalExpression ) ) )
            {
            // InternalSolidity.g:2735:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_value_2_0= ruleConditionalExpression ) ) )
            // InternalSolidity.g:2736:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_value_2_0= ruleConditionalExpression ) )
            {
            // InternalSolidity.g:2736:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==26) ) {
                    alt46=1;
                }
            }
            switch (alt46) {
                case 1 :
                    // InternalSolidity.g:2737:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // InternalSolidity.g:2737:4: ( (otherlv_0= RULE_ID ) )
                    // InternalSolidity.g:2738:5: (otherlv_0= RULE_ID )
                    {
                    // InternalSolidity.g:2738:5: (otherlv_0= RULE_ID )
                    // InternalSolidity.g:2739:6: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getArgumentRule());
                      						}
                      					
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_0, grammarAccess.getArgumentAccess().getParameterParameterCrossReference_0_0_0());
                      					
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,26,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getArgumentAccess().getEqualsSignKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalSolidity.g:2755:3: ( (lv_value_2_0= ruleConditionalExpression ) )
            // InternalSolidity.g:2756:4: (lv_value_2_0= ruleConditionalExpression )
            {
            // InternalSolidity.g:2756:4: (lv_value_2_0= ruleConditionalExpression )
            // InternalSolidity.g:2757:5: lv_value_2_0= ruleConditionalExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getArgumentAccess().getValueConditionalExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getArgumentRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"org.yakindu.base.expressions.Expressions.ConditionalExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // InternalSolidity.g:2778:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // InternalSolidity.g:2778:64: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // InternalSolidity.g:2779:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // InternalSolidity.g:2785:1: ruleParenthesizedExpression returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2791:2: ( ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalSolidity.g:2792:2: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalSolidity.g:2792:2: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalSolidity.g:2793:3: () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            // InternalSolidity.g:2793:3: ()
            // InternalSolidity.g:2794:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParenthesizedExpressionAccess().getParenthesizedExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalSolidity.g:2804:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalSolidity.g:2805:4: (lv_expression_2_0= ruleExpression )
            {
            // InternalSolidity.g:2805:4: (lv_expression_2_0= ruleExpression )
            // InternalSolidity.g:2806:5: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_50);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParenthesizedExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"org.yakindu.base.expressions.Expressions.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleTypeSpecifier"
    // InternalSolidity.g:2831:1: entryRuleTypeSpecifier returns [EObject current=null] : iv_ruleTypeSpecifier= ruleTypeSpecifier EOF ;
    public final EObject entryRuleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSpecifier = null;


        try {
            // InternalSolidity.g:2831:54: (iv_ruleTypeSpecifier= ruleTypeSpecifier EOF )
            // InternalSolidity.g:2832:2: iv_ruleTypeSpecifier= ruleTypeSpecifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeSpecifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeSpecifier=ruleTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeSpecifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeSpecifier"


    // $ANTLR start "ruleTypeSpecifier"
    // InternalSolidity.g:2838:1: ruleTypeSpecifier returns [EObject current=null] : ( ( ( ruleQID ) ) (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )? ) ;
    public final EObject ruleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2844:2: ( ( ( ( ruleQID ) ) (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )? ) )
            // InternalSolidity.g:2845:2: ( ( ( ruleQID ) ) (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )? )
            {
            // InternalSolidity.g:2845:2: ( ( ( ruleQID ) ) (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )? )
            // InternalSolidity.g:2846:3: ( ( ruleQID ) ) (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )?
            {
            // InternalSolidity.g:2846:3: ( ( ruleQID ) )
            // InternalSolidity.g:2847:4: ( ruleQID )
            {
            // InternalSolidity.g:2847:4: ( ruleQID )
            // InternalSolidity.g:2848:5: ruleQID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypeSpecifierRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeSpecifierAccess().getTypeTypeCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_51);
            ruleQID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSolidity.g:2862:3: (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==44) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalSolidity.g:2863:4: otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' )
                    {
                    otherlv_1=(Token)match(input,44,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeSpecifierAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalSolidity.g:2867:4: ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' )
                    // InternalSolidity.g:2868:5: ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>'
                    {
                    // InternalSolidity.g:2868:5: ( (lv_typeArguments_2_0= ruleTypeSpecifier ) )
                    // InternalSolidity.g:2869:6: (lv_typeArguments_2_0= ruleTypeSpecifier )
                    {
                    // InternalSolidity.g:2869:6: (lv_typeArguments_2_0= ruleTypeSpecifier )
                    // InternalSolidity.g:2870:7: lv_typeArguments_2_0= ruleTypeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getTypeSpecifierAccess().getTypeArgumentsTypeSpecifierParserRuleCall_1_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_52);
                    lv_typeArguments_2_0=ruleTypeSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getTypeSpecifierRule());
                      							}
                      							add(
                      								current,
                      								"typeArguments",
                      								lv_typeArguments_2_0,
                      								"org.yakindu.base.expressions.Expressions.TypeSpecifier");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalSolidity.g:2887:5: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==23) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalSolidity.g:2888:6: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_3, grammarAccess.getTypeSpecifierAccess().getCommaKeyword_1_1_1_0());
                    	      					
                    	    }
                    	    // InternalSolidity.g:2892:6: ( (lv_typeArguments_4_0= ruleTypeSpecifier ) )
                    	    // InternalSolidity.g:2893:7: (lv_typeArguments_4_0= ruleTypeSpecifier )
                    	    {
                    	    // InternalSolidity.g:2893:7: (lv_typeArguments_4_0= ruleTypeSpecifier )
                    	    // InternalSolidity.g:2894:8: lv_typeArguments_4_0= ruleTypeSpecifier
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getTypeSpecifierAccess().getTypeArgumentsTypeSpecifierParserRuleCall_1_1_1_1_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_52);
                    	    lv_typeArguments_4_0=ruleTypeSpecifier();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      								if (current==null) {
                    	      									current = createModelElementForParent(grammarAccess.getTypeSpecifierRule());
                    	      								}
                    	      								add(
                    	      									current,
                    	      									"typeArguments",
                    	      									lv_typeArguments_4_0,
                    	      									"org.yakindu.base.expressions.Expressions.TypeSpecifier");
                    	      								afterParserOrEnumRuleCall();
                    	      							
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getTypeSpecifierAccess().getGreaterThanSignKeyword_1_1_2());
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeSpecifier"


    // $ANTLR start "entrySuperLiteral"
    // InternalSolidity.g:2922:1: entrySuperLiteral returns [EObject current=null] : iv_superLiteral= superLiteral EOF ;
    public final EObject entrySuperLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_superLiteral = null;


        try {
            // InternalSolidity.g:2922:49: (iv_superLiteral= superLiteral EOF )
            // InternalSolidity.g:2923:2: iv_superLiteral= superLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionsLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_superLiteral=superLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_superLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entrySuperLiteral"


    // $ANTLR start "superLiteral"
    // InternalSolidity.g:2929:1: superLiteral returns [EObject current=null] : (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_BinaryLiteral_3= ruleBinaryLiteral | this_DoubleLiteral_4= ruleDoubleLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_StringLiteral_6= ruleStringLiteral | this_NullLiteral_7= ruleNullLiteral ) ;
    public final EObject superLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BoolLiteral_0 = null;

        EObject this_IntLiteral_1 = null;

        EObject this_HexLiteral_2 = null;

        EObject this_BinaryLiteral_3 = null;

        EObject this_DoubleLiteral_4 = null;

        EObject this_FloatLiteral_5 = null;

        EObject this_StringLiteral_6 = null;

        EObject this_NullLiteral_7 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2935:2: ( (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_BinaryLiteral_3= ruleBinaryLiteral | this_DoubleLiteral_4= ruleDoubleLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_StringLiteral_6= ruleStringLiteral | this_NullLiteral_7= ruleNullLiteral ) )
            // InternalSolidity.g:2936:2: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_BinaryLiteral_3= ruleBinaryLiteral | this_DoubleLiteral_4= ruleDoubleLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_StringLiteral_6= ruleStringLiteral | this_NullLiteral_7= ruleNullLiteral )
            {
            // InternalSolidity.g:2936:2: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_BinaryLiteral_3= ruleBinaryLiteral | this_DoubleLiteral_4= ruleDoubleLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_StringLiteral_6= ruleStringLiteral | this_NullLiteral_7= ruleNullLiteral )
            int alt49=8;
            switch ( input.LA(1) ) {
            case RULE_BOOL:
                {
                alt49=1;
                }
                break;
            case RULE_INT:
                {
                alt49=2;
                }
                break;
            case RULE_HEX:
                {
                alt49=3;
                }
                break;
            case RULE_BINARY:
                {
                alt49=4;
                }
                break;
            case RULE_DOUBLE:
                {
                alt49=5;
                }
                break;
            case RULE_FLOAT:
                {
                alt49=6;
                }
                break;
            case RULE_STRING:
                {
                alt49=7;
                }
                break;
            case 46:
                {
                alt49=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalSolidity.g:2937:3: this_BoolLiteral_0= ruleBoolLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionsLiteralAccess().getBoolLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BoolLiteral_0=ruleBoolLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BoolLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:2946:3: this_IntLiteral_1= ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionsLiteralAccess().getIntLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IntLiteral_1=ruleIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSolidity.g:2955:3: this_HexLiteral_2= ruleHexLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionsLiteralAccess().getHexLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_HexLiteral_2=ruleHexLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_HexLiteral_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSolidity.g:2964:3: this_BinaryLiteral_3= ruleBinaryLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionsLiteralAccess().getBinaryLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BinaryLiteral_3=ruleBinaryLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BinaryLiteral_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSolidity.g:2973:3: this_DoubleLiteral_4= ruleDoubleLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionsLiteralAccess().getDoubleLiteralParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DoubleLiteral_4=ruleDoubleLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DoubleLiteral_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalSolidity.g:2982:3: this_FloatLiteral_5= ruleFloatLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionsLiteralAccess().getFloatLiteralParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FloatLiteral_5=ruleFloatLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FloatLiteral_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalSolidity.g:2991:3: this_StringLiteral_6= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionsLiteralAccess().getStringLiteralParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_6=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringLiteral_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalSolidity.g:3000:3: this_NullLiteral_7= ruleNullLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionsLiteralAccess().getNullLiteralParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NullLiteral_7=ruleNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NullLiteral_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "superLiteral"


    // $ANTLR start "entryRuleBoolLiteral"
    // InternalSolidity.g:3012:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // InternalSolidity.g:3012:52: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // InternalSolidity.g:3013:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBoolLiteral=ruleBoolLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolLiteral"


    // $ANTLR start "ruleBoolLiteral"
    // InternalSolidity.g:3019:1: ruleBoolLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BOOL ) ) ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3025:2: ( ( () ( (lv_value_1_0= RULE_BOOL ) ) ) )
            // InternalSolidity.g:3026:2: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            {
            // InternalSolidity.g:3026:2: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            // InternalSolidity.g:3027:3: () ( (lv_value_1_0= RULE_BOOL ) )
            {
            // InternalSolidity.g:3027:3: ()
            // InternalSolidity.g:3028:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBoolLiteralAccess().getBoolLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3034:3: ( (lv_value_1_0= RULE_BOOL ) )
            // InternalSolidity.g:3035:4: (lv_value_1_0= RULE_BOOL )
            {
            // InternalSolidity.g:3035:4: (lv_value_1_0= RULE_BOOL )
            // InternalSolidity.g:3036:5: lv_value_1_0= RULE_BOOL
            {
            lv_value_1_0=(Token)match(input,RULE_BOOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getBoolLiteralAccess().getValueBOOLTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBoolLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.yakindu.base.expressions.Expressions.BOOL");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // InternalSolidity.g:3056:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalSolidity.g:3056:51: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalSolidity.g:3057:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // InternalSolidity.g:3063:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3069:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalSolidity.g:3070:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalSolidity.g:3070:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // InternalSolidity.g:3071:3: () ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalSolidity.g:3071:3: ()
            // InternalSolidity.g:3072:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3078:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalSolidity.g:3079:4: (lv_value_1_0= RULE_INT )
            {
            // InternalSolidity.g:3079:4: (lv_value_1_0= RULE_INT )
            // InternalSolidity.g:3080:5: lv_value_1_0= RULE_INT
            {
            lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getIntLiteralAccess().getValueINTTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getIntLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.eclipse.xtext.common.Terminals.INT");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleDoubleLiteral"
    // InternalSolidity.g:3100:1: entryRuleDoubleLiteral returns [EObject current=null] : iv_ruleDoubleLiteral= ruleDoubleLiteral EOF ;
    public final EObject entryRuleDoubleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteral = null;


        try {
            // InternalSolidity.g:3100:54: (iv_ruleDoubleLiteral= ruleDoubleLiteral EOF )
            // InternalSolidity.g:3101:2: iv_ruleDoubleLiteral= ruleDoubleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDoubleLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDoubleLiteral=ruleDoubleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDoubleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleLiteral"


    // $ANTLR start "ruleDoubleLiteral"
    // InternalSolidity.g:3107:1: ruleDoubleLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_DOUBLE ) ) ) ;
    public final EObject ruleDoubleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3113:2: ( ( () ( (lv_value_1_0= RULE_DOUBLE ) ) ) )
            // InternalSolidity.g:3114:2: ( () ( (lv_value_1_0= RULE_DOUBLE ) ) )
            {
            // InternalSolidity.g:3114:2: ( () ( (lv_value_1_0= RULE_DOUBLE ) ) )
            // InternalSolidity.g:3115:3: () ( (lv_value_1_0= RULE_DOUBLE ) )
            {
            // InternalSolidity.g:3115:3: ()
            // InternalSolidity.g:3116:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDoubleLiteralAccess().getDoubleLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3122:3: ( (lv_value_1_0= RULE_DOUBLE ) )
            // InternalSolidity.g:3123:4: (lv_value_1_0= RULE_DOUBLE )
            {
            // InternalSolidity.g:3123:4: (lv_value_1_0= RULE_DOUBLE )
            // InternalSolidity.g:3124:5: lv_value_1_0= RULE_DOUBLE
            {
            lv_value_1_0=(Token)match(input,RULE_DOUBLE,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getDoubleLiteralAccess().getValueDOUBLETerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDoubleLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.yakindu.base.expressions.Expressions.DOUBLE");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoubleLiteral"


    // $ANTLR start "entryRuleFloatLiteral"
    // InternalSolidity.g:3144:1: entryRuleFloatLiteral returns [EObject current=null] : iv_ruleFloatLiteral= ruleFloatLiteral EOF ;
    public final EObject entryRuleFloatLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatLiteral = null;


        try {
            // InternalSolidity.g:3144:53: (iv_ruleFloatLiteral= ruleFloatLiteral EOF )
            // InternalSolidity.g:3145:2: iv_ruleFloatLiteral= ruleFloatLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFloatLiteral=ruleFloatLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloatLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloatLiteral"


    // $ANTLR start "ruleFloatLiteral"
    // InternalSolidity.g:3151:1: ruleFloatLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleFloatLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3157:2: ( ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) )
            // InternalSolidity.g:3158:2: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            {
            // InternalSolidity.g:3158:2: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            // InternalSolidity.g:3159:3: () ( (lv_value_1_0= RULE_FLOAT ) )
            {
            // InternalSolidity.g:3159:3: ()
            // InternalSolidity.g:3160:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloatLiteralAccess().getFloatLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3166:3: ( (lv_value_1_0= RULE_FLOAT ) )
            // InternalSolidity.g:3167:4: (lv_value_1_0= RULE_FLOAT )
            {
            // InternalSolidity.g:3167:4: (lv_value_1_0= RULE_FLOAT )
            // InternalSolidity.g:3168:5: lv_value_1_0= RULE_FLOAT
            {
            lv_value_1_0=(Token)match(input,RULE_FLOAT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getFloatLiteralAccess().getValueFLOATTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFloatLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.yakindu.base.expressions.Expressions.FLOAT");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatLiteral"


    // $ANTLR start "entryRuleHexLiteral"
    // InternalSolidity.g:3188:1: entryRuleHexLiteral returns [EObject current=null] : iv_ruleHexLiteral= ruleHexLiteral EOF ;
    public final EObject entryRuleHexLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexLiteral = null;


        try {
            // InternalSolidity.g:3188:51: (iv_ruleHexLiteral= ruleHexLiteral EOF )
            // InternalSolidity.g:3189:2: iv_ruleHexLiteral= ruleHexLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHexLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHexLiteral=ruleHexLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHexLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHexLiteral"


    // $ANTLR start "ruleHexLiteral"
    // InternalSolidity.g:3195:1: ruleHexLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_HEX ) ) ) ;
    public final EObject ruleHexLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3201:2: ( ( () ( (lv_value_1_0= RULE_HEX ) ) ) )
            // InternalSolidity.g:3202:2: ( () ( (lv_value_1_0= RULE_HEX ) ) )
            {
            // InternalSolidity.g:3202:2: ( () ( (lv_value_1_0= RULE_HEX ) ) )
            // InternalSolidity.g:3203:3: () ( (lv_value_1_0= RULE_HEX ) )
            {
            // InternalSolidity.g:3203:3: ()
            // InternalSolidity.g:3204:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getHexLiteralAccess().getHexLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3210:3: ( (lv_value_1_0= RULE_HEX ) )
            // InternalSolidity.g:3211:4: (lv_value_1_0= RULE_HEX )
            {
            // InternalSolidity.g:3211:4: (lv_value_1_0= RULE_HEX )
            // InternalSolidity.g:3212:5: lv_value_1_0= RULE_HEX
            {
            lv_value_1_0=(Token)match(input,RULE_HEX,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getHexLiteralAccess().getValueHEXTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getHexLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.yakindu.base.expressions.Expressions.HEX");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHexLiteral"


    // $ANTLR start "entryRuleBinaryLiteral"
    // InternalSolidity.g:3232:1: entryRuleBinaryLiteral returns [EObject current=null] : iv_ruleBinaryLiteral= ruleBinaryLiteral EOF ;
    public final EObject entryRuleBinaryLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryLiteral = null;


        try {
            // InternalSolidity.g:3232:54: (iv_ruleBinaryLiteral= ruleBinaryLiteral EOF )
            // InternalSolidity.g:3233:2: iv_ruleBinaryLiteral= ruleBinaryLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBinaryLiteral=ruleBinaryLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryLiteral"


    // $ANTLR start "ruleBinaryLiteral"
    // InternalSolidity.g:3239:1: ruleBinaryLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BINARY ) ) ) ;
    public final EObject ruleBinaryLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3245:2: ( ( () ( (lv_value_1_0= RULE_BINARY ) ) ) )
            // InternalSolidity.g:3246:2: ( () ( (lv_value_1_0= RULE_BINARY ) ) )
            {
            // InternalSolidity.g:3246:2: ( () ( (lv_value_1_0= RULE_BINARY ) ) )
            // InternalSolidity.g:3247:3: () ( (lv_value_1_0= RULE_BINARY ) )
            {
            // InternalSolidity.g:3247:3: ()
            // InternalSolidity.g:3248:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBinaryLiteralAccess().getBinaryLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3254:3: ( (lv_value_1_0= RULE_BINARY ) )
            // InternalSolidity.g:3255:4: (lv_value_1_0= RULE_BINARY )
            {
            // InternalSolidity.g:3255:4: (lv_value_1_0= RULE_BINARY )
            // InternalSolidity.g:3256:5: lv_value_1_0= RULE_BINARY
            {
            lv_value_1_0=(Token)match(input,RULE_BINARY,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getBinaryLiteralAccess().getValueBINARYTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBinaryLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.yakindu.base.expressions.Expressions.BINARY");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalSolidity.g:3276:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalSolidity.g:3276:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalSolidity.g:3277:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalSolidity.g:3283:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3289:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalSolidity.g:3290:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalSolidity.g:3290:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalSolidity.g:3291:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalSolidity.g:3291:3: ()
            // InternalSolidity.g:3292:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3298:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalSolidity.g:3299:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalSolidity.g:3299:4: (lv_value_1_0= RULE_STRING )
            // InternalSolidity.g:3300:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStringLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleNullLiteral"
    // InternalSolidity.g:3320:1: entryRuleNullLiteral returns [EObject current=null] : iv_ruleNullLiteral= ruleNullLiteral EOF ;
    public final EObject entryRuleNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteral = null;


        try {
            // InternalSolidity.g:3320:52: (iv_ruleNullLiteral= ruleNullLiteral EOF )
            // InternalSolidity.g:3321:2: iv_ruleNullLiteral= ruleNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNullLiteral=ruleNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNullLiteral"


    // $ANTLR start "ruleNullLiteral"
    // InternalSolidity.g:3327:1: ruleNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalSolidity.g:3333:2: ( ( () otherlv_1= 'null' ) )
            // InternalSolidity.g:3334:2: ( () otherlv_1= 'null' )
            {
            // InternalSolidity.g:3334:2: ( () otherlv_1= 'null' )
            // InternalSolidity.g:3335:3: () otherlv_1= 'null'
            {
            // InternalSolidity.g:3335:3: ()
            // InternalSolidity.g:3336:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getNullLiteralAccess().getNullLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getNullLiteralAccess().getNullKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullLiteral"


    // $ANTLR start "entryRuleLogicalAndOperator"
    // InternalSolidity.g:3350:1: entryRuleLogicalAndOperator returns [String current=null] : iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF ;
    public final String entryRuleLogicalAndOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalAndOperator = null;


        try {
            // InternalSolidity.g:3350:58: (iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF )
            // InternalSolidity.g:3351:2: iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndOperator=ruleLogicalAndOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalAndOperator"


    // $ANTLR start "ruleLogicalAndOperator"
    // InternalSolidity.g:3357:1: ruleLogicalAndOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleLogicalAndOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3363:2: (kw= '&&' )
            // InternalSolidity.g:3364:2: kw= '&&'
            {
            kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getLogicalAndOperatorAccess().getAmpersandAmpersandKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalAndOperator"


    // $ANTLR start "entryRuleLogicalOrOperator"
    // InternalSolidity.g:3372:1: entryRuleLogicalOrOperator returns [String current=null] : iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF ;
    public final String entryRuleLogicalOrOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOrOperator = null;


        try {
            // InternalSolidity.g:3372:57: (iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF )
            // InternalSolidity.g:3373:2: iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOrOperator=ruleLogicalOrOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalOrOperator"


    // $ANTLR start "ruleLogicalOrOperator"
    // InternalSolidity.g:3379:1: ruleLogicalOrOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleLogicalOrOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3385:2: (kw= '||' )
            // InternalSolidity.g:3386:2: kw= '||'
            {
            kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getLogicalOrOperatorAccess().getVerticalLineVerticalLineKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalOrOperator"


    // $ANTLR start "entryRuleLogicalNotOperator"
    // InternalSolidity.g:3394:1: entryRuleLogicalNotOperator returns [String current=null] : iv_ruleLogicalNotOperator= ruleLogicalNotOperator EOF ;
    public final String entryRuleLogicalNotOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalNotOperator = null;


        try {
            // InternalSolidity.g:3394:58: (iv_ruleLogicalNotOperator= ruleLogicalNotOperator EOF )
            // InternalSolidity.g:3395:2: iv_ruleLogicalNotOperator= ruleLogicalNotOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalNotOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalNotOperator=ruleLogicalNotOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalNotOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalNotOperator"


    // $ANTLR start "ruleLogicalNotOperator"
    // InternalSolidity.g:3401:1: ruleLogicalNotOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '!' ;
    public final AntlrDatatypeRuleToken ruleLogicalNotOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3407:2: (kw= '!' )
            // InternalSolidity.g:3408:2: kw= '!'
            {
            kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getLogicalNotOperatorAccess().getExclamationMarkKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalNotOperator"


    // $ANTLR start "entryRuleBitwiseXOrOperator"
    // InternalSolidity.g:3416:1: entryRuleBitwiseXOrOperator returns [String current=null] : iv_ruleBitwiseXOrOperator= ruleBitwiseXOrOperator EOF ;
    public final String entryRuleBitwiseXOrOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBitwiseXOrOperator = null;


        try {
            // InternalSolidity.g:3416:58: (iv_ruleBitwiseXOrOperator= ruleBitwiseXOrOperator EOF )
            // InternalSolidity.g:3417:2: iv_ruleBitwiseXOrOperator= ruleBitwiseXOrOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseXOrOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitwiseXOrOperator=ruleBitwiseXOrOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseXOrOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseXOrOperator"


    // $ANTLR start "ruleBitwiseXOrOperator"
    // InternalSolidity.g:3423:1: ruleBitwiseXOrOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '^' ;
    public final AntlrDatatypeRuleToken ruleBitwiseXOrOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3429:2: (kw= '^' )
            // InternalSolidity.g:3430:2: kw= '^'
            {
            kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getBitwiseXOrOperatorAccess().getCircumflexAccentKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseXOrOperator"


    // $ANTLR start "entryRuleBitwiseOrOperator"
    // InternalSolidity.g:3438:1: entryRuleBitwiseOrOperator returns [String current=null] : iv_ruleBitwiseOrOperator= ruleBitwiseOrOperator EOF ;
    public final String entryRuleBitwiseOrOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBitwiseOrOperator = null;


        try {
            // InternalSolidity.g:3438:57: (iv_ruleBitwiseOrOperator= ruleBitwiseOrOperator EOF )
            // InternalSolidity.g:3439:2: iv_ruleBitwiseOrOperator= ruleBitwiseOrOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseOrOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitwiseOrOperator=ruleBitwiseOrOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseOrOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseOrOperator"


    // $ANTLR start "ruleBitwiseOrOperator"
    // InternalSolidity.g:3445:1: ruleBitwiseOrOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '|' ;
    public final AntlrDatatypeRuleToken ruleBitwiseOrOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3451:2: (kw= '|' )
            // InternalSolidity.g:3452:2: kw= '|'
            {
            kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getBitwiseOrOperatorAccess().getVerticalLineKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseOrOperator"


    // $ANTLR start "entryRuleBitwiseAndOperator"
    // InternalSolidity.g:3460:1: entryRuleBitwiseAndOperator returns [String current=null] : iv_ruleBitwiseAndOperator= ruleBitwiseAndOperator EOF ;
    public final String entryRuleBitwiseAndOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBitwiseAndOperator = null;


        try {
            // InternalSolidity.g:3460:58: (iv_ruleBitwiseAndOperator= ruleBitwiseAndOperator EOF )
            // InternalSolidity.g:3461:2: iv_ruleBitwiseAndOperator= ruleBitwiseAndOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitwiseAndOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitwiseAndOperator=ruleBitwiseAndOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitwiseAndOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitwiseAndOperator"


    // $ANTLR start "ruleBitwiseAndOperator"
    // InternalSolidity.g:3467:1: ruleBitwiseAndOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&' ;
    public final AntlrDatatypeRuleToken ruleBitwiseAndOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3473:2: (kw= '&' )
            // InternalSolidity.g:3474:2: kw= '&'
            {
            kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getBitwiseAndOperatorAccess().getAmpersandKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitwiseAndOperator"


    // $ANTLR start "entryRuleQID"
    // InternalSolidity.g:3482:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // InternalSolidity.g:3482:43: (iv_ruleQID= ruleQID EOF )
            // InternalSolidity.g:3483:2: iv_ruleQID= ruleQID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQIDRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQID=ruleQID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQID.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // InternalSolidity.g:3489:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalSolidity.g:3495:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalSolidity.g:3496:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalSolidity.g:3496:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalSolidity.g:3497:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalSolidity.g:3504:3: (kw= '.' this_ID_2= RULE_ID )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==41) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalSolidity.g:3505:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,41,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_42); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQID"


    // $ANTLR start "ruleContractType"
    // InternalSolidity.g:3522:1: ruleContractType returns [Enumerator current=null] : ( (enumLiteral_0= 'contract' ) | (enumLiteral_1= 'library' ) | (enumLiteral_2= 'interface' ) ) ;
    public final Enumerator ruleContractType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalSolidity.g:3528:2: ( ( (enumLiteral_0= 'contract' ) | (enumLiteral_1= 'library' ) | (enumLiteral_2= 'interface' ) ) )
            // InternalSolidity.g:3529:2: ( (enumLiteral_0= 'contract' ) | (enumLiteral_1= 'library' ) | (enumLiteral_2= 'interface' ) )
            {
            // InternalSolidity.g:3529:2: ( (enumLiteral_0= 'contract' ) | (enumLiteral_1= 'library' ) | (enumLiteral_2= 'interface' ) )
            int alt51=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt51=1;
                }
                break;
            case 54:
                {
                alt51=2;
                }
                break;
            case 55:
                {
                alt51=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalSolidity.g:3530:3: (enumLiteral_0= 'contract' )
                    {
                    // InternalSolidity.g:3530:3: (enumLiteral_0= 'contract' )
                    // InternalSolidity.g:3531:4: enumLiteral_0= 'contract'
                    {
                    enumLiteral_0=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getContractTypeAccess().getCONTRACTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getContractTypeAccess().getCONTRACTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3538:3: (enumLiteral_1= 'library' )
                    {
                    // InternalSolidity.g:3538:3: (enumLiteral_1= 'library' )
                    // InternalSolidity.g:3539:4: enumLiteral_1= 'library'
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getContractTypeAccess().getLIBRARYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getContractTypeAccess().getLIBRARYEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3546:3: (enumLiteral_2= 'interface' )
                    {
                    // InternalSolidity.g:3546:3: (enumLiteral_2= 'interface' )
                    // InternalSolidity.g:3547:4: enumLiteral_2= 'interface'
                    {
                    enumLiteral_2=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getContractTypeAccess().getINTERFACEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getContractTypeAccess().getINTERFACEEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractType"


    // $ANTLR start "ruleVisibility"
    // InternalSolidity.g:3557:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'internal' ) | (enumLiteral_2= 'private' ) | (enumLiteral_3= 'constant' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalSolidity.g:3563:2: ( ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'internal' ) | (enumLiteral_2= 'private' ) | (enumLiteral_3= 'constant' ) ) )
            // InternalSolidity.g:3564:2: ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'internal' ) | (enumLiteral_2= 'private' ) | (enumLiteral_3= 'constant' ) )
            {
            // InternalSolidity.g:3564:2: ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'internal' ) | (enumLiteral_2= 'private' ) | (enumLiteral_3= 'constant' ) )
            int alt52=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt52=1;
                }
                break;
            case 34:
                {
                alt52=2;
                }
                break;
            case 35:
                {
                alt52=3;
                }
                break;
            case 36:
                {
                alt52=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalSolidity.g:3565:3: (enumLiteral_0= 'public' )
                    {
                    // InternalSolidity.g:3565:3: (enumLiteral_0= 'public' )
                    // InternalSolidity.g:3566:4: enumLiteral_0= 'public'
                    {
                    enumLiteral_0=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3573:3: (enumLiteral_1= 'internal' )
                    {
                    // InternalSolidity.g:3573:3: (enumLiteral_1= 'internal' )
                    // InternalSolidity.g:3574:4: enumLiteral_1= 'internal'
                    {
                    enumLiteral_1=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3581:3: (enumLiteral_2= 'private' )
                    {
                    // InternalSolidity.g:3581:3: (enumLiteral_2= 'private' )
                    // InternalSolidity.g:3582:4: enumLiteral_2= 'private'
                    {
                    enumLiteral_2=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSolidity.g:3589:3: (enumLiteral_3= 'constant' )
                    {
                    // InternalSolidity.g:3589:3: (enumLiteral_3= 'constant' )
                    // InternalSolidity.g:3590:4: enumLiteral_3= 'constant'
                    {
                    enumLiteral_3=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVisibilityAccess().getCONSTANTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getVisibilityAccess().getCONSTANTEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVisibility"


    // $ANTLR start "ruleAssignmentOperator"
    // InternalSolidity.g:3600:1: ruleAssignmentOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) ) ;
    public final Enumerator ruleAssignmentOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;


        	enterRule();

        try {
            // InternalSolidity.g:3606:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) ) )
            // InternalSolidity.g:3607:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) )
            {
            // InternalSolidity.g:3607:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) )
            int alt53=11;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt53=1;
                }
                break;
            case 56:
                {
                alt53=2;
                }
                break;
            case 57:
                {
                alt53=3;
                }
                break;
            case 58:
                {
                alt53=4;
                }
                break;
            case 59:
                {
                alt53=5;
                }
                break;
            case 60:
                {
                alt53=6;
                }
                break;
            case 61:
                {
                alt53=7;
                }
                break;
            case 62:
                {
                alt53=8;
                }
                break;
            case 63:
                {
                alt53=9;
                }
                break;
            case 64:
                {
                alt53=10;
                }
                break;
            case 65:
                {
                alt53=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalSolidity.g:3608:3: (enumLiteral_0= '=' )
                    {
                    // InternalSolidity.g:3608:3: (enumLiteral_0= '=' )
                    // InternalSolidity.g:3609:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,26,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssignmentOperatorAccess().getAssignEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3616:3: (enumLiteral_1= '*=' )
                    {
                    // InternalSolidity.g:3616:3: (enumLiteral_1= '*=' )
                    // InternalSolidity.g:3617:4: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3624:3: (enumLiteral_2= '/=' )
                    {
                    // InternalSolidity.g:3624:3: (enumLiteral_2= '/=' )
                    // InternalSolidity.g:3625:4: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSolidity.g:3632:3: (enumLiteral_3= '%=' )
                    {
                    // InternalSolidity.g:3632:3: (enumLiteral_3= '%=' )
                    // InternalSolidity.g:3633:4: enumLiteral_3= '%='
                    {
                    enumLiteral_3=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSolidity.g:3640:3: (enumLiteral_4= '+=' )
                    {
                    // InternalSolidity.g:3640:3: (enumLiteral_4= '+=' )
                    // InternalSolidity.g:3641:4: enumLiteral_4= '+='
                    {
                    enumLiteral_4=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalSolidity.g:3648:3: (enumLiteral_5= '-=' )
                    {
                    // InternalSolidity.g:3648:3: (enumLiteral_5= '-=' )
                    // InternalSolidity.g:3649:4: enumLiteral_5= '-='
                    {
                    enumLiteral_5=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalSolidity.g:3656:3: (enumLiteral_6= '<<=' )
                    {
                    // InternalSolidity.g:3656:3: (enumLiteral_6= '<<=' )
                    // InternalSolidity.g:3657:4: enumLiteral_6= '<<='
                    {
                    enumLiteral_6=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalSolidity.g:3664:3: (enumLiteral_7= '>>=' )
                    {
                    // InternalSolidity.g:3664:3: (enumLiteral_7= '>>=' )
                    // InternalSolidity.g:3665:4: enumLiteral_7= '>>='
                    {
                    enumLiteral_7=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalSolidity.g:3672:3: (enumLiteral_8= '&=' )
                    {
                    // InternalSolidity.g:3672:3: (enumLiteral_8= '&=' )
                    // InternalSolidity.g:3673:4: enumLiteral_8= '&='
                    {
                    enumLiteral_8=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalSolidity.g:3680:3: (enumLiteral_9= '^=' )
                    {
                    // InternalSolidity.g:3680:3: (enumLiteral_9= '^=' )
                    // InternalSolidity.g:3681:4: enumLiteral_9= '^='
                    {
                    enumLiteral_9=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalSolidity.g:3688:3: (enumLiteral_10= '|=' )
                    {
                    // InternalSolidity.g:3688:3: (enumLiteral_10= '|=' )
                    // InternalSolidity.g:3689:4: enumLiteral_10= '|='
                    {
                    enumLiteral_10=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getAssignmentOperatorAccess().getOrAssignEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOperator"


    // $ANTLR start "ruleShiftOperator"
    // InternalSolidity.g:3699:1: ruleShiftOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalSolidity.g:3705:2: ( ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) )
            // InternalSolidity.g:3706:2: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            {
            // InternalSolidity.g:3706:2: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==66) ) {
                alt54=1;
            }
            else if ( (LA54_0==67) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalSolidity.g:3707:3: (enumLiteral_0= '<<' )
                    {
                    // InternalSolidity.g:3707:3: (enumLiteral_0= '<<' )
                    // InternalSolidity.g:3708:4: enumLiteral_0= '<<'
                    {
                    enumLiteral_0=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3715:3: (enumLiteral_1= '>>' )
                    {
                    // InternalSolidity.g:3715:3: (enumLiteral_1= '>>' )
                    // InternalSolidity.g:3716:4: enumLiteral_1= '>>'
                    {
                    enumLiteral_1=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getShiftOperatorAccess().getRightEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftOperator"


    // $ANTLR start "ruleAdditiveOperator"
    // InternalSolidity.g:3726:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalSolidity.g:3732:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalSolidity.g:3733:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalSolidity.g:3733:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==68) ) {
                alt55=1;
            }
            else if ( (LA55_0==69) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalSolidity.g:3734:3: (enumLiteral_0= '+' )
                    {
                    // InternalSolidity.g:3734:3: (enumLiteral_0= '+' )
                    // InternalSolidity.g:3735:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3742:3: (enumLiteral_1= '-' )
                    {
                    // InternalSolidity.g:3742:3: (enumLiteral_1= '-' )
                    // InternalSolidity.g:3743:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAdditiveOperatorAccess().getMinusEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveOperator"


    // $ANTLR start "ruleMultiplicativeOperator"
    // InternalSolidity.g:3753:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalSolidity.g:3759:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalSolidity.g:3760:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalSolidity.g:3760:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt56=3;
            switch ( input.LA(1) ) {
            case 70:
                {
                alt56=1;
                }
                break;
            case 71:
                {
                alt56=2;
                }
                break;
            case 72:
                {
                alt56=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalSolidity.g:3761:3: (enumLiteral_0= '*' )
                    {
                    // InternalSolidity.g:3761:3: (enumLiteral_0= '*' )
                    // InternalSolidity.g:3762:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3769:3: (enumLiteral_1= '/' )
                    {
                    // InternalSolidity.g:3769:3: (enumLiteral_1= '/' )
                    // InternalSolidity.g:3770:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3777:3: (enumLiteral_2= '%' )
                    {
                    // InternalSolidity.g:3777:3: (enumLiteral_2= '%' )
                    // InternalSolidity.g:3778:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getMultiplicativeOperatorAccess().getModEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeOperator"


    // $ANTLR start "ruleUnaryOperator"
    // InternalSolidity.g:3788:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalSolidity.g:3794:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) )
            // InternalSolidity.g:3795:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            {
            // InternalSolidity.g:3795:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 68:
                {
                alt57=1;
                }
                break;
            case 69:
                {
                alt57=2;
                }
                break;
            case 73:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalSolidity.g:3796:3: (enumLiteral_0= '+' )
                    {
                    // InternalSolidity.g:3796:3: (enumLiteral_0= '+' )
                    // InternalSolidity.g:3797:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3804:3: (enumLiteral_1= '-' )
                    {
                    // InternalSolidity.g:3804:3: (enumLiteral_1= '-' )
                    // InternalSolidity.g:3805:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3812:3: (enumLiteral_2= '~' )
                    {
                    // InternalSolidity.g:3812:3: (enumLiteral_2= '~' )
                    // InternalSolidity.g:3813:4: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getUnaryOperatorAccess().getComplementEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "ruleRelationalOperator"
    // InternalSolidity.g:3823:1: ruleRelationalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalSolidity.g:3829:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) )
            // InternalSolidity.g:3830:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            {
            // InternalSolidity.g:3830:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            int alt58=6;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt58=1;
                }
                break;
            case 74:
                {
                alt58=2;
                }
                break;
            case 45:
                {
                alt58=3;
                }
                break;
            case 75:
                {
                alt58=4;
                }
                break;
            case 76:
                {
                alt58=5;
                }
                break;
            case 77:
                {
                alt58=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalSolidity.g:3831:3: (enumLiteral_0= '<' )
                    {
                    // InternalSolidity.g:3831:3: (enumLiteral_0= '<' )
                    // InternalSolidity.g:3832:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3839:3: (enumLiteral_1= '<=' )
                    {
                    // InternalSolidity.g:3839:3: (enumLiteral_1= '<=' )
                    // InternalSolidity.g:3840:4: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3847:3: (enumLiteral_2= '>' )
                    {
                    // InternalSolidity.g:3847:3: (enumLiteral_2= '>' )
                    // InternalSolidity.g:3848:4: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSolidity.g:3855:3: (enumLiteral_3= '>=' )
                    {
                    // InternalSolidity.g:3855:3: (enumLiteral_3= '>=' )
                    // InternalSolidity.g:3856:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSolidity.g:3863:3: (enumLiteral_4= '==' )
                    {
                    // InternalSolidity.g:3863:3: (enumLiteral_4= '==' )
                    // InternalSolidity.g:3864:4: enumLiteral_4= '=='
                    {
                    enumLiteral_4=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalSolidity.g:3871:3: (enumLiteral_5= '!=' )
                    {
                    // InternalSolidity.g:3871:3: (enumLiteral_5= '!=' )
                    // InternalSolidity.g:3872:4: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalOperator"

    // $ANTLR start synpred1_InternalSolidity
    public final void synpred1_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:1906:4: ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )
        // InternalSolidity.g:1906:5: ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) )
        {
        // InternalSolidity.g:1906:5: ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) )
        // InternalSolidity.g:1907:5: () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) )
        {
        // InternalSolidity.g:1907:5: ()
        // InternalSolidity.g:1908:5: 
        {
        }

        // InternalSolidity.g:1909:5: ( ( ruleAdditiveOperator ) )
        // InternalSolidity.g:1910:6: ( ruleAdditiveOperator )
        {
        // InternalSolidity.g:1910:6: ( ruleAdditiveOperator )
        // InternalSolidity.g:1911:7: ruleAdditiveOperator
        {
        pushFollow(FOLLOW_32);
        ruleAdditiveOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalSolidity.g:1914:5: ( ( ruleNumericalMultiplyDivideExpression ) )
        // InternalSolidity.g:1915:6: ( ruleNumericalMultiplyDivideExpression )
        {
        // InternalSolidity.g:1915:6: ( ruleNumericalMultiplyDivideExpression )
        // InternalSolidity.g:1916:7: ruleNumericalMultiplyDivideExpression
        {
        pushFollow(FOLLOW_2);
        ruleNumericalMultiplyDivideExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalSolidity

    // $ANTLR start synpred2_InternalSolidity
    public final void synpred2_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:1997:4: ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )
        // InternalSolidity.g:1997:5: ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) )
        {
        // InternalSolidity.g:1997:5: ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) )
        // InternalSolidity.g:1998:5: () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) )
        {
        // InternalSolidity.g:1998:5: ()
        // InternalSolidity.g:1999:5: 
        {
        }

        // InternalSolidity.g:2000:5: ( ( ruleMultiplicativeOperator ) )
        // InternalSolidity.g:2001:6: ( ruleMultiplicativeOperator )
        {
        // InternalSolidity.g:2001:6: ( ruleMultiplicativeOperator )
        // InternalSolidity.g:2002:7: ruleMultiplicativeOperator
        {
        pushFollow(FOLLOW_32);
        ruleMultiplicativeOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalSolidity.g:2005:5: ( ( ruleNumericalUnaryExpression ) )
        // InternalSolidity.g:2006:6: ( ruleNumericalUnaryExpression )
        {
        // InternalSolidity.g:2006:6: ( ruleNumericalUnaryExpression )
        // InternalSolidity.g:2007:7: ruleNumericalUnaryExpression
        {
        pushFollow(FOLLOW_2);
        ruleNumericalUnaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalSolidity

    // $ANTLR start synpred3_InternalSolidity
    public final void synpred3_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2338:7: ( ( '(' ) )
        // InternalSolidity.g:2338:8: ( '(' )
        {
        // InternalSolidity.g:2338:8: ( '(' )
        // InternalSolidity.g:2339:8: '('
        {
        match(input,28,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalSolidity

    // $ANTLR start synpred4_InternalSolidity
    public final void synpred4_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2409:7: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )
        // InternalSolidity.g:2409:8: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        {
        // InternalSolidity.g:2409:8: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        // InternalSolidity.g:2410:8: ( ( '[' ) ) ( ( ruleExpression ) ) ']'
        {
        // InternalSolidity.g:2410:8: ( ( '[' ) )
        // InternalSolidity.g:2411:9: ( '[' )
        {
        // InternalSolidity.g:2411:9: ( '[' )
        // InternalSolidity.g:2412:10: '['
        {
        match(input,42,FOLLOW_17); if (state.failed) return ;

        }


        }

        // InternalSolidity.g:2415:8: ( ( ruleExpression ) )
        // InternalSolidity.g:2416:9: ( ruleExpression )
        {
        // InternalSolidity.g:2416:9: ( ruleExpression )
        // InternalSolidity.g:2417:10: ruleExpression
        {
        pushFollow(FOLLOW_45);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,43,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalSolidity

    // $ANTLR start synpred5_InternalSolidity
    public final void synpred5_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2464:7: ( ( '[' ( ( ruleExpression ) ) ']' ) )
        // InternalSolidity.g:2464:8: ( '[' ( ( ruleExpression ) ) ']' )
        {
        // InternalSolidity.g:2464:8: ( '[' ( ( ruleExpression ) ) ']' )
        // InternalSolidity.g:2465:8: '[' ( ( ruleExpression ) ) ']'
        {
        match(input,42,FOLLOW_17); if (state.failed) return ;
        // InternalSolidity.g:2466:8: ( ( ruleExpression ) )
        // InternalSolidity.g:2467:9: ( ruleExpression )
        {
        // InternalSolidity.g:2467:9: ( ruleExpression )
        // InternalSolidity.g:2468:10: ruleExpression
        {
        pushFollow(FOLLOW_45);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,43,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalSolidity

    // $ANTLR start synpred6_InternalSolidity
    public final void synpred6_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2549:6: ( ( '(' ) )
        // InternalSolidity.g:2549:7: ( '(' )
        {
        // InternalSolidity.g:2549:7: ( '(' )
        // InternalSolidity.g:2550:7: '('
        {
        match(input,28,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalSolidity

    // $ANTLR start synpred7_InternalSolidity
    public final void synpred7_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2620:6: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )
        // InternalSolidity.g:2620:7: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        {
        // InternalSolidity.g:2620:7: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        // InternalSolidity.g:2621:7: ( ( '[' ) ) ( ( ruleExpression ) ) ']'
        {
        // InternalSolidity.g:2621:7: ( ( '[' ) )
        // InternalSolidity.g:2622:8: ( '[' )
        {
        // InternalSolidity.g:2622:8: ( '[' )
        // InternalSolidity.g:2623:9: '['
        {
        match(input,42,FOLLOW_17); if (state.failed) return ;

        }


        }

        // InternalSolidity.g:2626:7: ( ( ruleExpression ) )
        // InternalSolidity.g:2627:8: ( ruleExpression )
        {
        // InternalSolidity.g:2627:8: ( ruleExpression )
        // InternalSolidity.g:2628:9: ruleExpression
        {
        pushFollow(FOLLOW_45);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,43,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalSolidity

    // $ANTLR start synpred8_InternalSolidity
    public final void synpred8_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2675:6: ( ( '[' ( ( ruleExpression ) ) ']' ) )
        // InternalSolidity.g:2675:7: ( '[' ( ( ruleExpression ) ) ']' )
        {
        // InternalSolidity.g:2675:7: ( '[' ( ( ruleExpression ) ) ']' )
        // InternalSolidity.g:2676:7: '[' ( ( ruleExpression ) ) ']'
        {
        match(input,42,FOLLOW_17); if (state.failed) return ;
        // InternalSolidity.g:2677:7: ( ( ruleExpression ) )
        // InternalSolidity.g:2678:8: ( ruleExpression )
        {
        // InternalSolidity.g:2678:8: ( ruleExpression )
        // InternalSolidity.g:2679:9: ruleExpression
        {
        pushFollow(FOLLOW_45);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,43,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalSolidity

    // Delegated rules

    public final boolean synpred7_InternalSolidity() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalSolidity_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalSolidity() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalSolidity_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalSolidity() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalSolidity_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalSolidity() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalSolidity_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalSolidity() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalSolidity_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalSolidity() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalSolidity_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalSolidity() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalSolidity_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalSolidity() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalSolidity_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00E0000000100002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00E0000000000002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000000408A000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000001E00000040L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000004080000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0002400050001FE0L,0x0000000000000230L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000020800040L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020800000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0002400052001FE0L,0x0000000000000230L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000010000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000003F01080000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000001080040L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0xFF00000004000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000400050001FE0L,0x0000000000000230L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000300000000002L,0x0000000000003C00L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x00000000000001C0L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000400050001FE0L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000060010000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0002400070001FE0L,0x0000000000000230L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000040010000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000200000800000L});

}