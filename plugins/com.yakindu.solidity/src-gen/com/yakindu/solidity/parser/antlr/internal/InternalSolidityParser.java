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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_VERSION", "RULE_STRING", "RULE_ID", "RULE_BOOL", "RULE_INT", "RULE_DOUBLE", "RULE_FLOAT", "RULE_HEX", "RULE_BINARY", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'pragma'", "'solidity'", "';'", "'import'", "'as'", "'is'", "','", "'{'", "'}'", "'='", "'struct'", "'modifier'", "'('", "')'", "'_;'", "'function'", "'external'", "'public'", "'internal'", "'private'", "'returns'", "'...'", "':'", "'event'", "'enum'", "'?'", "'.'", "'['", "']'", "'<'", "'>'", "'null'", "'&&'", "'||'", "'!'", "'^'", "'|'", "'&'", "'contract'", "'library'", "'interface'", "'constant'", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'<<'", "'>>'", "'+'", "'-'", "'*'", "'/'", "'%'", "'~'", "'<='", "'>='", "'=='", "'!='"
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
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
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

                if ( (LA1_0==17||LA1_0==20||(LA1_0>=55 && LA1_0<=57)) ) {
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
    // InternalSolidity.g:108:1: ruleSourceUnit returns [EObject current=null] : (this_PragmaDirective_0= rulePragmaDirective | this_ImportDirective_1= ruleImportDirective | this_ContractDefinition_2= ruleContractDefinition ) ;
    public final EObject ruleSourceUnit() throws RecognitionException {
        EObject current = null;

        EObject this_PragmaDirective_0 = null;

        EObject this_ImportDirective_1 = null;

        EObject this_ContractDefinition_2 = null;



        	enterRule();

        try {
            // InternalSolidity.g:114:2: ( (this_PragmaDirective_0= rulePragmaDirective | this_ImportDirective_1= ruleImportDirective | this_ContractDefinition_2= ruleContractDefinition ) )
            // InternalSolidity.g:115:2: (this_PragmaDirective_0= rulePragmaDirective | this_ImportDirective_1= ruleImportDirective | this_ContractDefinition_2= ruleContractDefinition )
            {
            // InternalSolidity.g:115:2: (this_PragmaDirective_0= rulePragmaDirective | this_ImportDirective_1= ruleImportDirective | this_ContractDefinition_2= ruleContractDefinition )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt2=1;
                }
                break;
            case 20:
                {
                alt2=2;
                }
                break;
            case 55:
            case 56:
            case 57:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalSolidity.g:116:3: this_PragmaDirective_0= rulePragmaDirective
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSourceUnitAccess().getPragmaDirectiveParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PragmaDirective_0=rulePragmaDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PragmaDirective_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:125:3: this_ImportDirective_1= ruleImportDirective
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSourceUnitAccess().getImportDirectiveParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ImportDirective_1=ruleImportDirective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ImportDirective_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSolidity.g:134:3: this_ContractDefinition_2= ruleContractDefinition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getSourceUnitAccess().getContractDefinitionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ContractDefinition_2=ruleContractDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ContractDefinition_2;
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
    // $ANTLR end "ruleSourceUnit"


    // $ANTLR start "entryRulePragmaDirective"
    // InternalSolidity.g:146:1: entryRulePragmaDirective returns [EObject current=null] : iv_rulePragmaDirective= rulePragmaDirective EOF ;
    public final EObject entryRulePragmaDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePragmaDirective = null;


        try {
            // InternalSolidity.g:146:56: (iv_rulePragmaDirective= rulePragmaDirective EOF )
            // InternalSolidity.g:147:2: iv_rulePragmaDirective= rulePragmaDirective EOF
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
    // InternalSolidity.g:153:1: rulePragmaDirective returns [EObject current=null] : (otherlv_0= 'pragma' otherlv_1= 'solidity' ( (lv_id_2_0= RULE_VERSION ) ) otherlv_3= ';' ) ;
    public final EObject rulePragmaDirective() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_id_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalSolidity.g:159:2: ( (otherlv_0= 'pragma' otherlv_1= 'solidity' ( (lv_id_2_0= RULE_VERSION ) ) otherlv_3= ';' ) )
            // InternalSolidity.g:160:2: (otherlv_0= 'pragma' otherlv_1= 'solidity' ( (lv_id_2_0= RULE_VERSION ) ) otherlv_3= ';' )
            {
            // InternalSolidity.g:160:2: (otherlv_0= 'pragma' otherlv_1= 'solidity' ( (lv_id_2_0= RULE_VERSION ) ) otherlv_3= ';' )
            // InternalSolidity.g:161:3: otherlv_0= 'pragma' otherlv_1= 'solidity' ( (lv_id_2_0= RULE_VERSION ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getPragmaDirectiveAccess().getPragmaKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,18,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPragmaDirectiveAccess().getSolidityKeyword_1());
              		
            }
            // InternalSolidity.g:169:3: ( (lv_id_2_0= RULE_VERSION ) )
            // InternalSolidity.g:170:4: (lv_id_2_0= RULE_VERSION )
            {
            // InternalSolidity.g:170:4: (lv_id_2_0= RULE_VERSION )
            // InternalSolidity.g:171:5: lv_id_2_0= RULE_VERSION
            {
            lv_id_2_0=(Token)match(input,RULE_VERSION,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_id_2_0, grammarAccess.getPragmaDirectiveAccess().getIdVERSIONTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPragmaDirectiveRule());
              					}
              					setWithLastConsumed(
              						current,
              						"id",
              						lv_id_2_0,
              						"com.yakindu.solidity.Solidity.VERSION");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getPragmaDirectiveAccess().getSemicolonKeyword_3());
              		
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
    // InternalSolidity.g:195:1: entryRuleImportDirective returns [EObject current=null] : iv_ruleImportDirective= ruleImportDirective EOF ;
    public final EObject entryRuleImportDirective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportDirective = null;


        try {
            // InternalSolidity.g:195:56: (iv_ruleImportDirective= ruleImportDirective EOF )
            // InternalSolidity.g:196:2: iv_ruleImportDirective= ruleImportDirective EOF
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
    // InternalSolidity.g:202:1: ruleImportDirective returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_STRING ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleImportDirective() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importedNamespace_1_0=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalSolidity.g:208:2: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_STRING ) ) )? otherlv_4= ';' ) )
            // InternalSolidity.g:209:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_STRING ) ) )? otherlv_4= ';' )
            {
            // InternalSolidity.g:209:2: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_STRING ) ) )? otherlv_4= ';' )
            // InternalSolidity.g:210:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= RULE_STRING ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_STRING ) ) )? otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportDirectiveAccess().getImportKeyword_0());
              		
            }
            // InternalSolidity.g:214:3: ( (lv_importedNamespace_1_0= RULE_STRING ) )
            // InternalSolidity.g:215:4: (lv_importedNamespace_1_0= RULE_STRING )
            {
            // InternalSolidity.g:215:4: (lv_importedNamespace_1_0= RULE_STRING )
            // InternalSolidity.g:216:5: lv_importedNamespace_1_0= RULE_STRING
            {
            lv_importedNamespace_1_0=(Token)match(input,RULE_STRING,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_importedNamespace_1_0, grammarAccess.getImportDirectiveAccess().getImportedNamespaceSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportDirectiveRule());
              					}
              					setWithLastConsumed(
              						current,
              						"importedNamespace",
              						lv_importedNamespace_1_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            // InternalSolidity.g:232:3: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_STRING ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==21) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalSolidity.g:233:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getImportDirectiveAccess().getAsKeyword_2_0());
                      			
                    }
                    // InternalSolidity.g:237:4: ( (lv_alias_3_0= RULE_STRING ) )
                    // InternalSolidity.g:238:5: (lv_alias_3_0= RULE_STRING )
                    {
                    // InternalSolidity.g:238:5: (lv_alias_3_0= RULE_STRING )
                    // InternalSolidity.g:239:6: lv_alias_3_0= RULE_STRING
                    {
                    lv_alias_3_0=(Token)match(input,RULE_STRING,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_alias_3_0, grammarAccess.getImportDirectiveAccess().getAliasSTRINGTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getImportDirectiveRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"alias",
                      							lv_alias_3_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getImportDirectiveAccess().getSemicolonKeyword_3());
              		
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
    // InternalSolidity.g:264:1: entryRuleContractDefinition returns [EObject current=null] : iv_ruleContractDefinition= ruleContractDefinition EOF ;
    public final EObject entryRuleContractDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractDefinition = null;


        try {
            // InternalSolidity.g:264:59: (iv_ruleContractDefinition= ruleContractDefinition EOF )
            // InternalSolidity.g:265:2: iv_ruleContractDefinition= ruleContractDefinition EOF
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
    // InternalSolidity.g:271:1: ruleContractDefinition returns [EObject current=null] : ( ( (lv_type_0_0= ruleContractType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'is' ( (lv_superType_3_0= ruleInheritanceSpecifier ) ) (otherlv_4= ',' ( (lv_superType_5_0= ruleInheritanceSpecifier ) ) )* )? otherlv_6= '{' ( (lv_parts_7_0= ruleContractPart ) )* otherlv_8= '}' ) ;
    public final EObject ruleContractDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_superType_3_0 = null;

        EObject lv_superType_5_0 = null;

        EObject lv_parts_7_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:277:2: ( ( ( (lv_type_0_0= ruleContractType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'is' ( (lv_superType_3_0= ruleInheritanceSpecifier ) ) (otherlv_4= ',' ( (lv_superType_5_0= ruleInheritanceSpecifier ) ) )* )? otherlv_6= '{' ( (lv_parts_7_0= ruleContractPart ) )* otherlv_8= '}' ) )
            // InternalSolidity.g:278:2: ( ( (lv_type_0_0= ruleContractType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'is' ( (lv_superType_3_0= ruleInheritanceSpecifier ) ) (otherlv_4= ',' ( (lv_superType_5_0= ruleInheritanceSpecifier ) ) )* )? otherlv_6= '{' ( (lv_parts_7_0= ruleContractPart ) )* otherlv_8= '}' )
            {
            // InternalSolidity.g:278:2: ( ( (lv_type_0_0= ruleContractType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'is' ( (lv_superType_3_0= ruleInheritanceSpecifier ) ) (otherlv_4= ',' ( (lv_superType_5_0= ruleInheritanceSpecifier ) ) )* )? otherlv_6= '{' ( (lv_parts_7_0= ruleContractPart ) )* otherlv_8= '}' )
            // InternalSolidity.g:279:3: ( (lv_type_0_0= ruleContractType ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'is' ( (lv_superType_3_0= ruleInheritanceSpecifier ) ) (otherlv_4= ',' ( (lv_superType_5_0= ruleInheritanceSpecifier ) ) )* )? otherlv_6= '{' ( (lv_parts_7_0= ruleContractPart ) )* otherlv_8= '}'
            {
            // InternalSolidity.g:279:3: ( (lv_type_0_0= ruleContractType ) )
            // InternalSolidity.g:280:4: (lv_type_0_0= ruleContractType )
            {
            // InternalSolidity.g:280:4: (lv_type_0_0= ruleContractType )
            // InternalSolidity.g:281:5: lv_type_0_0= ruleContractType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getContractDefinitionAccess().getTypeContractTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_type_0_0=ruleContractType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getContractDefinitionRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"com.yakindu.solidity.Solidity.ContractType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSolidity.g:298:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSolidity.g:299:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSolidity.g:299:4: (lv_name_1_0= RULE_ID )
            // InternalSolidity.g:300:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getContractDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getContractDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSolidity.g:316:3: (otherlv_2= 'is' ( (lv_superType_3_0= ruleInheritanceSpecifier ) ) (otherlv_4= ',' ( (lv_superType_5_0= ruleInheritanceSpecifier ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==22) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSolidity.g:317:4: otherlv_2= 'is' ( (lv_superType_3_0= ruleInheritanceSpecifier ) ) (otherlv_4= ',' ( (lv_superType_5_0= ruleInheritanceSpecifier ) ) )*
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getContractDefinitionAccess().getIsKeyword_2_0());
                      			
                    }
                    // InternalSolidity.g:321:4: ( (lv_superType_3_0= ruleInheritanceSpecifier ) )
                    // InternalSolidity.g:322:5: (lv_superType_3_0= ruleInheritanceSpecifier )
                    {
                    // InternalSolidity.g:322:5: (lv_superType_3_0= ruleInheritanceSpecifier )
                    // InternalSolidity.g:323:6: lv_superType_3_0= ruleInheritanceSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getContractDefinitionAccess().getSuperTypeInheritanceSpecifierParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_11);
                    lv_superType_3_0=ruleInheritanceSpecifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getContractDefinitionRule());
                      						}
                      						add(
                      							current,
                      							"superType",
                      							lv_superType_3_0,
                      							"com.yakindu.solidity.Solidity.InheritanceSpecifier");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSolidity.g:340:4: (otherlv_4= ',' ( (lv_superType_5_0= ruleInheritanceSpecifier ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==23) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalSolidity.g:341:5: otherlv_4= ',' ( (lv_superType_5_0= ruleInheritanceSpecifier ) )
                    	    {
                    	    otherlv_4=(Token)match(input,23,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getContractDefinitionAccess().getCommaKeyword_2_2_0());
                    	      				
                    	    }
                    	    // InternalSolidity.g:345:5: ( (lv_superType_5_0= ruleInheritanceSpecifier ) )
                    	    // InternalSolidity.g:346:6: (lv_superType_5_0= ruleInheritanceSpecifier )
                    	    {
                    	    // InternalSolidity.g:346:6: (lv_superType_5_0= ruleInheritanceSpecifier )
                    	    // InternalSolidity.g:347:7: lv_superType_5_0= ruleInheritanceSpecifier
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getContractDefinitionAccess().getSuperTypeInheritanceSpecifierParserRuleCall_2_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_superType_5_0=ruleInheritanceSpecifier();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getContractDefinitionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"superType",
                    	      								lv_superType_5_0,
                    	      								"com.yakindu.solidity.Solidity.InheritanceSpecifier");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,24,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getContractDefinitionAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalSolidity.g:370:3: ( (lv_parts_7_0= ruleContractPart ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||(LA6_0>=27 && LA6_0<=28)||LA6_0==32||(LA6_0>=40 && LA6_0<=41)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalSolidity.g:371:4: (lv_parts_7_0= ruleContractPart )
            	    {
            	    // InternalSolidity.g:371:4: (lv_parts_7_0= ruleContractPart )
            	    // InternalSolidity.g:372:5: lv_parts_7_0= ruleContractPart
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getContractDefinitionAccess().getPartsContractPartParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_parts_7_0=ruleContractPart();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getContractDefinitionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"parts",
            	      						lv_parts_7_0,
            	      						"com.yakindu.solidity.Solidity.ContractPart");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getContractDefinitionAccess().getRightCurlyBracketKeyword_5());
              		
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


    // $ANTLR start "entryRuleInheritanceSpecifier"
    // InternalSolidity.g:397:1: entryRuleInheritanceSpecifier returns [EObject current=null] : iv_ruleInheritanceSpecifier= ruleInheritanceSpecifier EOF ;
    public final EObject entryRuleInheritanceSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInheritanceSpecifier = null;


        try {
            // InternalSolidity.g:397:61: (iv_ruleInheritanceSpecifier= ruleInheritanceSpecifier EOF )
            // InternalSolidity.g:398:2: iv_ruleInheritanceSpecifier= ruleInheritanceSpecifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInheritanceSpecifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInheritanceSpecifier=ruleInheritanceSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInheritanceSpecifier; 
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
    // $ANTLR end "entryRuleInheritanceSpecifier"


    // $ANTLR start "ruleInheritanceSpecifier"
    // InternalSolidity.g:404:1: ruleInheritanceSpecifier returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleInheritanceSpecifier() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:410:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalSolidity.g:411:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalSolidity.g:411:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalSolidity.g:412:3: (lv_name_0_0= RULE_ID )
            {
            // InternalSolidity.g:412:3: (lv_name_0_0= RULE_ID )
            // InternalSolidity.g:413:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_name_0_0, grammarAccess.getInheritanceSpecifierAccess().getNameIDTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getInheritanceSpecifierRule());
              				}
              				setWithLastConsumed(
              					current,
              					"name",
              					lv_name_0_0,
              					"org.eclipse.xtext.common.Terminals.ID");
              			
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
    // $ANTLR end "ruleInheritanceSpecifier"


    // $ANTLR start "entryRuleContractPart"
    // InternalSolidity.g:432:1: entryRuleContractPart returns [EObject current=null] : iv_ruleContractPart= ruleContractPart EOF ;
    public final EObject entryRuleContractPart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractPart = null;


        try {
            // InternalSolidity.g:432:53: (iv_ruleContractPart= ruleContractPart EOF )
            // InternalSolidity.g:433:2: iv_ruleContractPart= ruleContractPart EOF
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
    // InternalSolidity.g:439:1: ruleContractPart returns [EObject current=null] : ( ( (lv_parts_0_1= ruleVariableDeclaration | lv_parts_0_2= ruleStructDefinition | lv_parts_0_3= ruleModifierDefinition | lv_parts_0_4= ruleFunctionDefinition | lv_parts_0_5= ruleEventDefinition | lv_parts_0_6= ruleEnumDefinition ) ) ) ;
    public final EObject ruleContractPart() throws RecognitionException {
        EObject current = null;

        EObject lv_parts_0_1 = null;

        EObject lv_parts_0_2 = null;

        EObject lv_parts_0_3 = null;

        EObject lv_parts_0_4 = null;

        EObject lv_parts_0_5 = null;

        EObject lv_parts_0_6 = null;



        	enterRule();

        try {
            // InternalSolidity.g:445:2: ( ( ( (lv_parts_0_1= ruleVariableDeclaration | lv_parts_0_2= ruleStructDefinition | lv_parts_0_3= ruleModifierDefinition | lv_parts_0_4= ruleFunctionDefinition | lv_parts_0_5= ruleEventDefinition | lv_parts_0_6= ruleEnumDefinition ) ) ) )
            // InternalSolidity.g:446:2: ( ( (lv_parts_0_1= ruleVariableDeclaration | lv_parts_0_2= ruleStructDefinition | lv_parts_0_3= ruleModifierDefinition | lv_parts_0_4= ruleFunctionDefinition | lv_parts_0_5= ruleEventDefinition | lv_parts_0_6= ruleEnumDefinition ) ) )
            {
            // InternalSolidity.g:446:2: ( ( (lv_parts_0_1= ruleVariableDeclaration | lv_parts_0_2= ruleStructDefinition | lv_parts_0_3= ruleModifierDefinition | lv_parts_0_4= ruleFunctionDefinition | lv_parts_0_5= ruleEventDefinition | lv_parts_0_6= ruleEnumDefinition ) ) )
            // InternalSolidity.g:447:3: ( (lv_parts_0_1= ruleVariableDeclaration | lv_parts_0_2= ruleStructDefinition | lv_parts_0_3= ruleModifierDefinition | lv_parts_0_4= ruleFunctionDefinition | lv_parts_0_5= ruleEventDefinition | lv_parts_0_6= ruleEnumDefinition ) )
            {
            // InternalSolidity.g:447:3: ( (lv_parts_0_1= ruleVariableDeclaration | lv_parts_0_2= ruleStructDefinition | lv_parts_0_3= ruleModifierDefinition | lv_parts_0_4= ruleFunctionDefinition | lv_parts_0_5= ruleEventDefinition | lv_parts_0_6= ruleEnumDefinition ) )
            // InternalSolidity.g:448:4: (lv_parts_0_1= ruleVariableDeclaration | lv_parts_0_2= ruleStructDefinition | lv_parts_0_3= ruleModifierDefinition | lv_parts_0_4= ruleFunctionDefinition | lv_parts_0_5= ruleEventDefinition | lv_parts_0_6= ruleEnumDefinition )
            {
            // InternalSolidity.g:448:4: (lv_parts_0_1= ruleVariableDeclaration | lv_parts_0_2= ruleStructDefinition | lv_parts_0_3= ruleModifierDefinition | lv_parts_0_4= ruleFunctionDefinition | lv_parts_0_5= ruleEventDefinition | lv_parts_0_6= ruleEnumDefinition )
            int alt7=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt7=1;
                }
                break;
            case 27:
                {
                alt7=2;
                }
                break;
            case 28:
                {
                alt7=3;
                }
                break;
            case 32:
                {
                alt7=4;
                }
                break;
            case 40:
                {
                alt7=5;
                }
                break;
            case 41:
                {
                alt7=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalSolidity.g:449:5: lv_parts_0_1= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getContractPartAccess().getPartsVariableDeclarationParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_parts_0_1=ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getContractPartRule());
                      					}
                      					add(
                      						current,
                      						"parts",
                      						lv_parts_0_1,
                      						"com.yakindu.solidity.Solidity.VariableDeclaration");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:465:5: lv_parts_0_2= ruleStructDefinition
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getContractPartAccess().getPartsStructDefinitionParserRuleCall_0_1());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_parts_0_2=ruleStructDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getContractPartRule());
                      					}
                      					add(
                      						current,
                      						"parts",
                      						lv_parts_0_2,
                      						"com.yakindu.solidity.Solidity.StructDefinition");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }
                    break;
                case 3 :
                    // InternalSolidity.g:481:5: lv_parts_0_3= ruleModifierDefinition
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getContractPartAccess().getPartsModifierDefinitionParserRuleCall_0_2());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_parts_0_3=ruleModifierDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getContractPartRule());
                      					}
                      					add(
                      						current,
                      						"parts",
                      						lv_parts_0_3,
                      						"com.yakindu.solidity.Solidity.ModifierDefinition");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }
                    break;
                case 4 :
                    // InternalSolidity.g:497:5: lv_parts_0_4= ruleFunctionDefinition
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getContractPartAccess().getPartsFunctionDefinitionParserRuleCall_0_3());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_parts_0_4=ruleFunctionDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getContractPartRule());
                      					}
                      					add(
                      						current,
                      						"parts",
                      						lv_parts_0_4,
                      						"com.yakindu.solidity.Solidity.FunctionDefinition");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }
                    break;
                case 5 :
                    // InternalSolidity.g:513:5: lv_parts_0_5= ruleEventDefinition
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getContractPartAccess().getPartsEventDefinitionParserRuleCall_0_4());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_parts_0_5=ruleEventDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getContractPartRule());
                      					}
                      					add(
                      						current,
                      						"parts",
                      						lv_parts_0_5,
                      						"com.yakindu.solidity.Solidity.EventDefinition");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }
                    break;
                case 6 :
                    // InternalSolidity.g:529:5: lv_parts_0_6= ruleEnumDefinition
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getContractPartAccess().getPartsEnumDefinitionParserRuleCall_0_5());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_parts_0_6=ruleEnumDefinition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getContractPartRule());
                      					}
                      					add(
                      						current,
                      						"parts",
                      						lv_parts_0_6,
                      						"com.yakindu.solidity.Solidity.EnumDefinition");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }
                    break;

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
    // $ANTLR end "ruleContractPart"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalSolidity.g:550:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalSolidity.g:550:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalSolidity.g:551:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
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
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalSolidity.g:557:1: ruleVariableDeclaration returns [EObject current=null] : ( ( ( ruleQID ) ) ( (lv_visibility_1_0= ruleVisibility ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_initialValue_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Enumerator lv_visibility_1_0 = null;

        EObject lv_initialValue_4_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:563:2: ( ( ( ( ruleQID ) ) ( (lv_visibility_1_0= ruleVisibility ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_initialValue_4_0= ruleExpression ) ) )? ) )
            // InternalSolidity.g:564:2: ( ( ( ruleQID ) ) ( (lv_visibility_1_0= ruleVisibility ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_initialValue_4_0= ruleExpression ) ) )? )
            {
            // InternalSolidity.g:564:2: ( ( ( ruleQID ) ) ( (lv_visibility_1_0= ruleVisibility ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_initialValue_4_0= ruleExpression ) ) )? )
            // InternalSolidity.g:565:3: ( ( ruleQID ) ) ( (lv_visibility_1_0= ruleVisibility ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '=' ( (lv_initialValue_4_0= ruleExpression ) ) )?
            {
            // InternalSolidity.g:565:3: ( ( ruleQID ) )
            // InternalSolidity.g:566:4: ( ruleQID )
            {
            // InternalSolidity.g:566:4: ( ruleQID )
            // InternalSolidity.g:567:5: ruleQID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableDeclarationRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeEObjectCrossReference_0_0());
              				
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

            // InternalSolidity.g:581:3: ( (lv_visibility_1_0= ruleVisibility ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=34 && LA8_0<=36)||LA8_0==58) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSolidity.g:582:4: (lv_visibility_1_0= ruleVisibility )
                    {
                    // InternalSolidity.g:582:4: (lv_visibility_1_0= ruleVisibility )
                    // InternalSolidity.g:583:5: lv_visibility_1_0= ruleVisibility
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getVisibilityVisibilityEnumRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_9);
                    lv_visibility_1_0=ruleVisibility();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      					}
                      					set(
                      						current,
                      						"visibility",
                      						lv_visibility_1_0,
                      						"com.yakindu.solidity.Solidity.Visibility");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSolidity.g:600:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalSolidity.g:601:4: (lv_name_2_0= RULE_ID )
            {
            // InternalSolidity.g:601:4: (lv_name_2_0= RULE_ID )
            // InternalSolidity.g:602:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSolidity.g:618:3: (otherlv_3= '=' ( (lv_initialValue_4_0= ruleExpression ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==26) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSolidity.g:619:4: otherlv_3= '=' ( (lv_initialValue_4_0= ruleExpression ) )
                    {
                    otherlv_3=(Token)match(input,26,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalSolidity.g:623:4: ( (lv_initialValue_4_0= ruleExpression ) )
                    // InternalSolidity.g:624:5: (lv_initialValue_4_0= ruleExpression )
                    {
                    // InternalSolidity.g:624:5: (lv_initialValue_4_0= ruleExpression )
                    // InternalSolidity.g:625:6: lv_initialValue_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVariableDeclarationAccess().getInitialValueExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_initialValue_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"initialValue",
                      							lv_initialValue_4_0,
                      							"org.yakindu.base.expressions.Expressions.Expression");
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
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleStructDefinition"
    // InternalSolidity.g:647:1: entryRuleStructDefinition returns [EObject current=null] : iv_ruleStructDefinition= ruleStructDefinition EOF ;
    public final EObject entryRuleStructDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStructDefinition = null;


        try {
            // InternalSolidity.g:647:57: (iv_ruleStructDefinition= ruleStructDefinition EOF )
            // InternalSolidity.g:648:2: iv_ruleStructDefinition= ruleStructDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStructDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStructDefinition=ruleStructDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStructDefinition; 
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
    // $ANTLR end "entryRuleStructDefinition"


    // $ANTLR start "ruleStructDefinition"
    // InternalSolidity.g:654:1: ruleStructDefinition returns [EObject current=null] : (otherlv_0= 'struct' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_declarations_3_0= ruleVariableDeclaration ) ) otherlv_4= ';' )* otherlv_5= '}' ) ;
    public final EObject ruleStructDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_declarations_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:660:2: ( (otherlv_0= 'struct' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_declarations_3_0= ruleVariableDeclaration ) ) otherlv_4= ';' )* otherlv_5= '}' ) )
            // InternalSolidity.g:661:2: (otherlv_0= 'struct' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_declarations_3_0= ruleVariableDeclaration ) ) otherlv_4= ';' )* otherlv_5= '}' )
            {
            // InternalSolidity.g:661:2: (otherlv_0= 'struct' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_declarations_3_0= ruleVariableDeclaration ) ) otherlv_4= ';' )* otherlv_5= '}' )
            // InternalSolidity.g:662:3: otherlv_0= 'struct' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( ( (lv_declarations_3_0= ruleVariableDeclaration ) ) otherlv_4= ';' )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStructDefinitionAccess().getStructKeyword_0());
              		
            }
            // InternalSolidity.g:666:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSolidity.g:667:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSolidity.g:667:4: (lv_name_1_0= RULE_ID )
            // InternalSolidity.g:668:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getStructDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStructDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStructDefinitionAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalSolidity.g:688:3: ( ( (lv_declarations_3_0= ruleVariableDeclaration ) ) otherlv_4= ';' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSolidity.g:689:4: ( (lv_declarations_3_0= ruleVariableDeclaration ) ) otherlv_4= ';'
            	    {
            	    // InternalSolidity.g:689:4: ( (lv_declarations_3_0= ruleVariableDeclaration ) )
            	    // InternalSolidity.g:690:5: (lv_declarations_3_0= ruleVariableDeclaration )
            	    {
            	    // InternalSolidity.g:690:5: (lv_declarations_3_0= ruleVariableDeclaration )
            	    // InternalSolidity.g:691:6: lv_declarations_3_0= ruleVariableDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getStructDefinitionAccess().getDeclarationsVariableDeclarationParserRuleCall_3_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_declarations_3_0=ruleVariableDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getStructDefinitionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"declarations",
            	      							lv_declarations_3_0,
            	      							"com.yakindu.solidity.Solidity.VariableDeclaration");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_4=(Token)match(input,19,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getStructDefinitionAccess().getSemicolonKeyword_3_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_5=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getStructDefinitionAccess().getRightCurlyBracketKeyword_4());
              		
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
    // $ANTLR end "ruleStructDefinition"


    // $ANTLR start "entryRuleModifierDefinition"
    // InternalSolidity.g:721:1: entryRuleModifierDefinition returns [EObject current=null] : iv_ruleModifierDefinition= ruleModifierDefinition EOF ;
    public final EObject entryRuleModifierDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierDefinition = null;


        try {
            // InternalSolidity.g:721:59: (iv_ruleModifierDefinition= ruleModifierDefinition EOF )
            // InternalSolidity.g:722:2: iv_ruleModifierDefinition= ruleModifierDefinition EOF
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
    // InternalSolidity.g:728:1: ruleModifierDefinition returns [EObject current=null] : (otherlv_0= 'modifier' ( (lv_name_1_0= RULE_ID ) ) ( (lv_list_2_0= ruleParameterList ) ) ( (lv_block_3_0= ruleBlock ) ) ) ;
    public final EObject ruleModifierDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_list_2_0 = null;

        EObject lv_block_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:734:2: ( (otherlv_0= 'modifier' ( (lv_name_1_0= RULE_ID ) ) ( (lv_list_2_0= ruleParameterList ) ) ( (lv_block_3_0= ruleBlock ) ) ) )
            // InternalSolidity.g:735:2: (otherlv_0= 'modifier' ( (lv_name_1_0= RULE_ID ) ) ( (lv_list_2_0= ruleParameterList ) ) ( (lv_block_3_0= ruleBlock ) ) )
            {
            // InternalSolidity.g:735:2: (otherlv_0= 'modifier' ( (lv_name_1_0= RULE_ID ) ) ( (lv_list_2_0= ruleParameterList ) ) ( (lv_block_3_0= ruleBlock ) ) )
            // InternalSolidity.g:736:3: otherlv_0= 'modifier' ( (lv_name_1_0= RULE_ID ) ) ( (lv_list_2_0= ruleParameterList ) ) ( (lv_block_3_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getModifierDefinitionAccess().getModifierKeyword_0());
              		
            }
            // InternalSolidity.g:740:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSolidity.g:741:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSolidity.g:741:4: (lv_name_1_0= RULE_ID )
            // InternalSolidity.g:742:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getModifierDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getModifierDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSolidity.g:758:3: ( (lv_list_2_0= ruleParameterList ) )
            // InternalSolidity.g:759:4: (lv_list_2_0= ruleParameterList )
            {
            // InternalSolidity.g:759:4: (lv_list_2_0= ruleParameterList )
            // InternalSolidity.g:760:5: lv_list_2_0= ruleParameterList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModifierDefinitionAccess().getListParameterListParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_list_2_0=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModifierDefinitionRule());
              					}
              					set(
              						current,
              						"list",
              						lv_list_2_0,
              						"com.yakindu.solidity.Solidity.ParameterList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSolidity.g:777:3: ( (lv_block_3_0= ruleBlock ) )
            // InternalSolidity.g:778:4: (lv_block_3_0= ruleBlock )
            {
            // InternalSolidity.g:778:4: (lv_block_3_0= ruleBlock )
            // InternalSolidity.g:779:5: lv_block_3_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getModifierDefinitionAccess().getBlockBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_3_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getModifierDefinitionRule());
              					}
              					add(
              						current,
              						"block",
              						lv_block_3_0,
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
    // InternalSolidity.g:800:1: entryRuleParameterList returns [EObject current=null] : iv_ruleParameterList= ruleParameterList EOF ;
    public final EObject entryRuleParameterList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterList = null;


        try {
            // InternalSolidity.g:800:54: (iv_ruleParameterList= ruleParameterList EOF )
            // InternalSolidity.g:801:2: iv_ruleParameterList= ruleParameterList EOF
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
    // InternalSolidity.g:807:1: ruleParameterList returns [EObject current=null] : (otherlv_0= '(' () ( (lv_parameter_2_0= ruleParameter ) )? (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleParameterList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameter_2_0 = null;

        EObject lv_parameter_4_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:813:2: ( (otherlv_0= '(' () ( (lv_parameter_2_0= ruleParameter ) )? (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )* otherlv_5= ')' ) )
            // InternalSolidity.g:814:2: (otherlv_0= '(' () ( (lv_parameter_2_0= ruleParameter ) )? (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )* otherlv_5= ')' )
            {
            // InternalSolidity.g:814:2: (otherlv_0= '(' () ( (lv_parameter_2_0= ruleParameter ) )? (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )* otherlv_5= ')' )
            // InternalSolidity.g:815:3: otherlv_0= '(' () ( (lv_parameter_2_0= ruleParameter ) )? (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )* otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,29,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParameterListAccess().getLeftParenthesisKeyword_0());
              		
            }
            // InternalSolidity.g:819:3: ()
            // InternalSolidity.g:820:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParameterListAccess().getParameterListAction_1(),
              					current);
              			
            }

            }

            // InternalSolidity.g:826:3: ( (lv_parameter_2_0= ruleParameter ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSolidity.g:827:4: (lv_parameter_2_0= ruleParameter )
                    {
                    // InternalSolidity.g:827:4: (lv_parameter_2_0= ruleParameter )
                    // InternalSolidity.g:828:5: lv_parameter_2_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getParameterListAccess().getParameterParameterParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_20);
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

            // InternalSolidity.g:845:3: (otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalSolidity.g:846:4: otherlv_3= ',' ( (lv_parameter_4_0= ruleParameter ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getParameterListAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalSolidity.g:850:4: ( (lv_parameter_4_0= ruleParameter ) )
            	    // InternalSolidity.g:851:5: (lv_parameter_4_0= ruleParameter )
            	    {
            	    // InternalSolidity.g:851:5: (lv_parameter_4_0= ruleParameter )
            	    // InternalSolidity.g:852:6: lv_parameter_4_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getParameterListAccess().getParameterParameterParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
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

            otherlv_5=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:878:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalSolidity.g:878:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalSolidity.g:879:2: iv_ruleBlock= ruleBlock EOF
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
    // InternalSolidity.g:885:1: ruleBlock returns [EObject current=null] : (otherlv_0= '{' () ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:891:2: ( (otherlv_0= '{' () ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )* otherlv_4= '}' ) )
            // InternalSolidity.g:892:2: (otherlv_0= '{' () ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            {
            // InternalSolidity.g:892:2: (otherlv_0= '{' () ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )* otherlv_4= '}' )
            // InternalSolidity.g:893:3: otherlv_0= '{' () ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_0());
              		
            }
            // InternalSolidity.g:897:3: ()
            // InternalSolidity.g:898:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockAccess().getBlockAction_1(),
              					current);
              			
            }

            }

            // InternalSolidity.g:904:3: ( ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=RULE_STRING && LA13_0<=RULE_BINARY)||LA13_0==29||LA13_0==31||LA13_0==48||LA13_0==51||(LA13_0>=71 && LA13_0<=72)||LA13_0==76) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSolidity.g:905:4: ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ';'
            	    {
            	    // InternalSolidity.g:905:4: ( (lv_expression_2_0= ruleExpression ) )
            	    // InternalSolidity.g:906:5: (lv_expression_2_0= ruleExpression )
            	    {
            	    // InternalSolidity.g:906:5: (lv_expression_2_0= ruleExpression )
            	    // InternalSolidity.g:907:6: lv_expression_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBlockAccess().getExpressionExpressionParserRuleCall_2_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
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

            	    otherlv_3=(Token)match(input,19,FOLLOW_21); if (state.failed) return current;
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
    // InternalSolidity.g:937:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalSolidity.g:937:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalSolidity.g:938:2: iv_ruleLiteral= ruleLiteral EOF
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
    // InternalSolidity.g:944:1: ruleLiteral returns [EObject current=null] : (this_Literal_0= superLiteral | this_ModifierInvocationLiteral_1= ruleModifierInvocationLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_Literal_0 = null;

        EObject this_ModifierInvocationLiteral_1 = null;



        	enterRule();

        try {
            // InternalSolidity.g:950:2: ( (this_Literal_0= superLiteral | this_ModifierInvocationLiteral_1= ruleModifierInvocationLiteral ) )
            // InternalSolidity.g:951:2: (this_Literal_0= superLiteral | this_ModifierInvocationLiteral_1= ruleModifierInvocationLiteral )
            {
            // InternalSolidity.g:951:2: (this_Literal_0= superLiteral | this_ModifierInvocationLiteral_1= ruleModifierInvocationLiteral )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_STRING||(LA14_0>=RULE_BOOL && LA14_0<=RULE_BINARY)||LA14_0==48) ) {
                alt14=1;
            }
            else if ( (LA14_0==31) ) {
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
                    // InternalSolidity.g:952:3: this_Literal_0= superLiteral
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
                    // InternalSolidity.g:961:3: this_ModifierInvocationLiteral_1= ruleModifierInvocationLiteral
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
    // InternalSolidity.g:973:1: entryRuleModifierInvocationLiteral returns [EObject current=null] : iv_ruleModifierInvocationLiteral= ruleModifierInvocationLiteral EOF ;
    public final EObject entryRuleModifierInvocationLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifierInvocationLiteral = null;


        try {
            // InternalSolidity.g:973:66: (iv_ruleModifierInvocationLiteral= ruleModifierInvocationLiteral EOF )
            // InternalSolidity.g:974:2: iv_ruleModifierInvocationLiteral= ruleModifierInvocationLiteral EOF
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
    // InternalSolidity.g:980:1: ruleModifierInvocationLiteral returns [EObject current=null] : ( () otherlv_1= '_;' ) ;
    public final EObject ruleModifierInvocationLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalSolidity.g:986:2: ( ( () otherlv_1= '_;' ) )
            // InternalSolidity.g:987:2: ( () otherlv_1= '_;' )
            {
            // InternalSolidity.g:987:2: ( () otherlv_1= '_;' )
            // InternalSolidity.g:988:3: () otherlv_1= '_;'
            {
            // InternalSolidity.g:988:3: ()
            // InternalSolidity.g:989:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getModifierInvocationLiteralAccess().getModifierInvocationLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:1003:1: entryRuleFunctionDefinition returns [EObject current=null] : iv_ruleFunctionDefinition= ruleFunctionDefinition EOF ;
    public final EObject entryRuleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDefinition = null;


        try {
            // InternalSolidity.g:1003:59: (iv_ruleFunctionDefinition= ruleFunctionDefinition EOF )
            // InternalSolidity.g:1004:2: iv_ruleFunctionDefinition= ruleFunctionDefinition EOF
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
    // InternalSolidity.g:1010:1: ruleFunctionDefinition returns [EObject current=null] : (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) )? ( (lv_parameter_2_0= ruleParameterList ) ) (otherlv_3= 'external' | otherlv_4= 'public' | otherlv_5= 'internal' | otherlv_6= 'private' )* (otherlv_7= 'returns' ( (lv_returnParameter_8_0= ruleParameterList ) ) )? (otherlv_9= ';' | ( (lv_block_10_0= ruleBlock ) ) ) ) ;
    public final EObject ruleFunctionDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_parameter_2_0 = null;

        EObject lv_returnParameter_8_0 = null;

        EObject lv_block_10_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1016:2: ( (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) )? ( (lv_parameter_2_0= ruleParameterList ) ) (otherlv_3= 'external' | otherlv_4= 'public' | otherlv_5= 'internal' | otherlv_6= 'private' )* (otherlv_7= 'returns' ( (lv_returnParameter_8_0= ruleParameterList ) ) )? (otherlv_9= ';' | ( (lv_block_10_0= ruleBlock ) ) ) ) )
            // InternalSolidity.g:1017:2: (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) )? ( (lv_parameter_2_0= ruleParameterList ) ) (otherlv_3= 'external' | otherlv_4= 'public' | otherlv_5= 'internal' | otherlv_6= 'private' )* (otherlv_7= 'returns' ( (lv_returnParameter_8_0= ruleParameterList ) ) )? (otherlv_9= ';' | ( (lv_block_10_0= ruleBlock ) ) ) )
            {
            // InternalSolidity.g:1017:2: (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) )? ( (lv_parameter_2_0= ruleParameterList ) ) (otherlv_3= 'external' | otherlv_4= 'public' | otherlv_5= 'internal' | otherlv_6= 'private' )* (otherlv_7= 'returns' ( (lv_returnParameter_8_0= ruleParameterList ) ) )? (otherlv_9= ';' | ( (lv_block_10_0= ruleBlock ) ) ) )
            // InternalSolidity.g:1018:3: otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) )? ( (lv_parameter_2_0= ruleParameterList ) ) (otherlv_3= 'external' | otherlv_4= 'public' | otherlv_5= 'internal' | otherlv_6= 'private' )* (otherlv_7= 'returns' ( (lv_returnParameter_8_0= ruleParameterList ) ) )? (otherlv_9= ';' | ( (lv_block_10_0= ruleBlock ) ) )
            {
            otherlv_0=(Token)match(input,32,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFunctionDefinitionAccess().getFunctionKeyword_0());
              		
            }
            // InternalSolidity.g:1022:3: ( (lv_name_1_0= RULE_ID ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalSolidity.g:1023:4: (lv_name_1_0= RULE_ID )
                    {
                    // InternalSolidity.g:1023:4: (lv_name_1_0= RULE_ID )
                    // InternalSolidity.g:1024:5: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_name_1_0, grammarAccess.getFunctionDefinitionAccess().getNameIDTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getFunctionDefinitionRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"name",
                      						lv_name_1_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSolidity.g:1040:3: ( (lv_parameter_2_0= ruleParameterList ) )
            // InternalSolidity.g:1041:4: (lv_parameter_2_0= ruleParameterList )
            {
            // InternalSolidity.g:1041:4: (lv_parameter_2_0= ruleParameterList )
            // InternalSolidity.g:1042:5: lv_parameter_2_0= ruleParameterList
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getParameterParameterListParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_23);
            lv_parameter_2_0=ruleParameterList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
              					}
              					set(
              						current,
              						"parameter",
              						lv_parameter_2_0,
              						"com.yakindu.solidity.Solidity.ParameterList");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSolidity.g:1059:3: (otherlv_3= 'external' | otherlv_4= 'public' | otherlv_5= 'internal' | otherlv_6= 'private' )*
            loop16:
            do {
                int alt16=5;
                switch ( input.LA(1) ) {
                case 33:
                    {
                    alt16=1;
                    }
                    break;
                case 34:
                    {
                    alt16=2;
                    }
                    break;
                case 35:
                    {
                    alt16=3;
                    }
                    break;
                case 36:
                    {
                    alt16=4;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // InternalSolidity.g:1060:4: otherlv_3= 'external'
            	    {
            	    otherlv_3=(Token)match(input,33,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getFunctionDefinitionAccess().getExternalKeyword_3_0());
            	      			
            	    }

            	    }
            	    break;
            	case 2 :
            	    // InternalSolidity.g:1065:4: otherlv_4= 'public'
            	    {
            	    otherlv_4=(Token)match(input,34,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getFunctionDefinitionAccess().getPublicKeyword_3_1());
            	      			
            	    }

            	    }
            	    break;
            	case 3 :
            	    // InternalSolidity.g:1070:4: otherlv_5= 'internal'
            	    {
            	    otherlv_5=(Token)match(input,35,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_5, grammarAccess.getFunctionDefinitionAccess().getInternalKeyword_3_2());
            	      			
            	    }

            	    }
            	    break;
            	case 4 :
            	    // InternalSolidity.g:1075:4: otherlv_6= 'private'
            	    {
            	    otherlv_6=(Token)match(input,36,FOLLOW_23); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getFunctionDefinitionAccess().getPrivateKeyword_3_3());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // InternalSolidity.g:1080:3: (otherlv_7= 'returns' ( (lv_returnParameter_8_0= ruleParameterList ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==37) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSolidity.g:1081:4: otherlv_7= 'returns' ( (lv_returnParameter_8_0= ruleParameterList ) )
                    {
                    otherlv_7=(Token)match(input,37,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getFunctionDefinitionAccess().getReturnsKeyword_4_0());
                      			
                    }
                    // InternalSolidity.g:1085:4: ( (lv_returnParameter_8_0= ruleParameterList ) )
                    // InternalSolidity.g:1086:5: (lv_returnParameter_8_0= ruleParameterList )
                    {
                    // InternalSolidity.g:1086:5: (lv_returnParameter_8_0= ruleParameterList )
                    // InternalSolidity.g:1087:6: lv_returnParameter_8_0= ruleParameterList
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getReturnParameterParameterListParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
                    lv_returnParameter_8_0=ruleParameterList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      						}
                      						set(
                      							current,
                      							"returnParameter",
                      							lv_returnParameter_8_0,
                      							"com.yakindu.solidity.Solidity.ParameterList");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalSolidity.g:1105:3: (otherlv_9= ';' | ( (lv_block_10_0= ruleBlock ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19) ) {
                alt18=1;
            }
            else if ( (LA18_0==24) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalSolidity.g:1106:4: otherlv_9= ';'
                    {
                    otherlv_9=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getFunctionDefinitionAccess().getSemicolonKeyword_5_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:1111:4: ( (lv_block_10_0= ruleBlock ) )
                    {
                    // InternalSolidity.g:1111:4: ( (lv_block_10_0= ruleBlock ) )
                    // InternalSolidity.g:1112:5: (lv_block_10_0= ruleBlock )
                    {
                    // InternalSolidity.g:1112:5: (lv_block_10_0= ruleBlock )
                    // InternalSolidity.g:1113:6: lv_block_10_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDefinitionAccess().getBlockBlockParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_block_10_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDefinitionRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_10_0,
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
    // InternalSolidity.g:1135:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalSolidity.g:1135:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalSolidity.g:1136:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalSolidity.g:1142:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_varArgs_1_0= '...' ) )? otherlv_2= ':' ( (lv_typeSpecifier_3_0= ruleTypeSpecifier ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_varArgs_1_0=null;
        Token otherlv_2=null;
        EObject lv_typeSpecifier_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1148:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_varArgs_1_0= '...' ) )? otherlv_2= ':' ( (lv_typeSpecifier_3_0= ruleTypeSpecifier ) ) ) )
            // InternalSolidity.g:1149:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_varArgs_1_0= '...' ) )? otherlv_2= ':' ( (lv_typeSpecifier_3_0= ruleTypeSpecifier ) ) )
            {
            // InternalSolidity.g:1149:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_varArgs_1_0= '...' ) )? otherlv_2= ':' ( (lv_typeSpecifier_3_0= ruleTypeSpecifier ) ) )
            // InternalSolidity.g:1150:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_varArgs_1_0= '...' ) )? otherlv_2= ':' ( (lv_typeSpecifier_3_0= ruleTypeSpecifier ) )
            {
            // InternalSolidity.g:1150:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSolidity.g:1151:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSolidity.g:1151:4: (lv_name_0_0= RULE_ID )
            // InternalSolidity.g:1152:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getParameterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalSolidity.g:1168:3: ( (lv_varArgs_1_0= '...' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==38) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalSolidity.g:1169:4: (lv_varArgs_1_0= '...' )
                    {
                    // InternalSolidity.g:1169:4: (lv_varArgs_1_0= '...' )
                    // InternalSolidity.g:1170:5: lv_varArgs_1_0= '...'
                    {
                    lv_varArgs_1_0=(Token)match(input,38,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_varArgs_1_0, grammarAccess.getParameterAccess().getVarArgsFullStopFullStopFullStopKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getParameterRule());
                      					}
                      					setWithLastConsumed(current, "varArgs", true, "...");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,39,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
              		
            }
            // InternalSolidity.g:1186:3: ( (lv_typeSpecifier_3_0= ruleTypeSpecifier ) )
            // InternalSolidity.g:1187:4: (lv_typeSpecifier_3_0= ruleTypeSpecifier )
            {
            // InternalSolidity.g:1187:4: (lv_typeSpecifier_3_0= ruleTypeSpecifier )
            // InternalSolidity.g:1188:5: lv_typeSpecifier_3_0= ruleTypeSpecifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getTypeSpecifierTypeSpecifierParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_typeSpecifier_3_0=ruleTypeSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterRule());
              					}
              					set(
              						current,
              						"typeSpecifier",
              						lv_typeSpecifier_3_0,
              						"org.yakindu.base.expressions.Expressions.TypeSpecifier");
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleEventDefinition"
    // InternalSolidity.g:1209:1: entryRuleEventDefinition returns [EObject current=null] : iv_ruleEventDefinition= ruleEventDefinition EOF ;
    public final EObject entryRuleEventDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventDefinition = null;


        try {
            // InternalSolidity.g:1209:56: (iv_ruleEventDefinition= ruleEventDefinition EOF )
            // InternalSolidity.g:1210:2: iv_ruleEventDefinition= ruleEventDefinition EOF
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
    // InternalSolidity.g:1216:1: ruleEventDefinition returns [EObject current=null] : (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleEventDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:1222:2: ( (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSolidity.g:1223:2: (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSolidity.g:1223:2: (otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSolidity.g:1224:3: otherlv_0= 'event' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEventDefinitionAccess().getEventKeyword_0());
              		
            }
            // InternalSolidity.g:1228:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSolidity.g:1229:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSolidity.g:1229:4: (lv_name_1_0= RULE_ID )
            // InternalSolidity.g:1230:5: lv_name_1_0= RULE_ID
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


    // $ANTLR start "entryRuleEnumDefinition"
    // InternalSolidity.g:1250:1: entryRuleEnumDefinition returns [EObject current=null] : iv_ruleEnumDefinition= ruleEnumDefinition EOF ;
    public final EObject entryRuleEnumDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumDefinition = null;


        try {
            // InternalSolidity.g:1250:55: (iv_ruleEnumDefinition= ruleEnumDefinition EOF )
            // InternalSolidity.g:1251:2: iv_ruleEnumDefinition= ruleEnumDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumDefinition=ruleEnumDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumDefinition; 
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
    // $ANTLR end "entryRuleEnumDefinition"


    // $ANTLR start "ruleEnumDefinition"
    // InternalSolidity.g:1257:1: ruleEnumDefinition returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_value_3_0= RULE_STRING ) )? (otherlv_4= ',' ( (lv_value_5_0= RULE_STRING ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleEnumDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalSolidity.g:1263:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_value_3_0= RULE_STRING ) )? (otherlv_4= ',' ( (lv_value_5_0= RULE_STRING ) ) )* otherlv_6= '}' ) )
            // InternalSolidity.g:1264:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_value_3_0= RULE_STRING ) )? (otherlv_4= ',' ( (lv_value_5_0= RULE_STRING ) ) )* otherlv_6= '}' )
            {
            // InternalSolidity.g:1264:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_value_3_0= RULE_STRING ) )? (otherlv_4= ',' ( (lv_value_5_0= RULE_STRING ) ) )* otherlv_6= '}' )
            // InternalSolidity.g:1265:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_value_3_0= RULE_STRING ) )? (otherlv_4= ',' ( (lv_value_5_0= RULE_STRING ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumDefinitionAccess().getEnumKeyword_0());
              		
            }
            // InternalSolidity.g:1269:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSolidity.g:1270:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSolidity.g:1270:4: (lv_name_1_0= RULE_ID )
            // InternalSolidity.g:1271:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getEnumDefinitionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumDefinitionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,24,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEnumDefinitionAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalSolidity.g:1291:3: ( (lv_value_3_0= RULE_STRING ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_STRING) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalSolidity.g:1292:4: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalSolidity.g:1292:4: (lv_value_3_0= RULE_STRING )
                    // InternalSolidity.g:1293:5: lv_value_3_0= RULE_STRING
                    {
                    lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_value_3_0, grammarAccess.getEnumDefinitionAccess().getValueSTRINGTerminalRuleCall_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getEnumDefinitionRule());
                      					}
                      					addWithLastConsumed(
                      						current,
                      						"value",
                      						lv_value_3_0,
                      						"org.eclipse.xtext.common.Terminals.STRING");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSolidity.g:1309:3: (otherlv_4= ',' ( (lv_value_5_0= RULE_STRING ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==23) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalSolidity.g:1310:4: otherlv_4= ',' ( (lv_value_5_0= RULE_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_7); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getEnumDefinitionAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalSolidity.g:1314:4: ( (lv_value_5_0= RULE_STRING ) )
            	    // InternalSolidity.g:1315:5: (lv_value_5_0= RULE_STRING )
            	    {
            	    // InternalSolidity.g:1315:5: (lv_value_5_0= RULE_STRING )
            	    // InternalSolidity.g:1316:6: lv_value_5_0= RULE_STRING
            	    {
            	    lv_value_5_0=(Token)match(input,RULE_STRING,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_value_5_0, grammarAccess.getEnumDefinitionAccess().getValueSTRINGTerminalRuleCall_4_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getEnumDefinitionRule());
            	      						}
            	      						addWithLastConsumed(
            	      							current,
            	      							"value",
            	      							lv_value_5_0,
            	      							"org.eclipse.xtext.common.Terminals.STRING");
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_6=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEnumDefinitionAccess().getRightCurlyBracketKeyword_5());
              		
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
    // $ANTLR end "ruleEnumDefinition"


    // $ANTLR start "entryRuleExpression"
    // InternalSolidity.g:1341:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalSolidity.g:1341:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalSolidity.g:1342:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalSolidity.g:1348:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1354:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalSolidity.g:1355:2: this_AssignmentExpression_0= ruleAssignmentExpression
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
    // InternalSolidity.g:1366:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalSolidity.g:1366:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalSolidity.g:1367:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
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
    // InternalSolidity.g:1373:1: ruleAssignmentExpression returns [EObject current=null] : (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1379:2: ( (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* ) )
            // InternalSolidity.g:1380:2: (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* )
            {
            // InternalSolidity.g:1380:2: (this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )* )
            // InternalSolidity.g:1381:3: this_ConditionalExpression_0= ruleConditionalExpression ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getConditionalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_29);
            this_ConditionalExpression_0=ruleConditionalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ConditionalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1389:3: ( () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==26||(LA22_0>=59 && LA22_0<=68)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalSolidity.g:1390:4: () ( (lv_operator_2_0= ruleAssignmentOperator ) ) ( (lv_expression_3_0= ruleConditionalExpression ) )
            	    {
            	    // InternalSolidity.g:1390:4: ()
            	    // InternalSolidity.g:1391:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionVarRefAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalSolidity.g:1397:4: ( (lv_operator_2_0= ruleAssignmentOperator ) )
            	    // InternalSolidity.g:1398:5: (lv_operator_2_0= ruleAssignmentOperator )
            	    {
            	    // InternalSolidity.g:1398:5: (lv_operator_2_0= ruleAssignmentOperator )
            	    // InternalSolidity.g:1399:6: lv_operator_2_0= ruleAssignmentOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getOperatorAssignmentOperatorEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_15);
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

            	    // InternalSolidity.g:1416:4: ( (lv_expression_3_0= ruleConditionalExpression ) )
            	    // InternalSolidity.g:1417:5: (lv_expression_3_0= ruleConditionalExpression )
            	    {
            	    // InternalSolidity.g:1417:5: (lv_expression_3_0= ruleConditionalExpression )
            	    // InternalSolidity.g:1418:6: lv_expression_3_0= ruleConditionalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getExpressionConditionalExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
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
    // InternalSolidity.g:1440:1: entryRuleConditionalExpression returns [EObject current=null] : iv_ruleConditionalExpression= ruleConditionalExpression EOF ;
    public final EObject entryRuleConditionalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalExpression = null;


        try {
            // InternalSolidity.g:1440:62: (iv_ruleConditionalExpression= ruleConditionalExpression EOF )
            // InternalSolidity.g:1441:2: iv_ruleConditionalExpression= ruleConditionalExpression EOF
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
    // InternalSolidity.g:1447:1: ruleConditionalExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? ) ;
    public final EObject ruleConditionalExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_LogicalOrExpression_0 = null;

        EObject lv_trueCase_3_0 = null;

        EObject lv_falseCase_5_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1453:2: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? ) )
            // InternalSolidity.g:1454:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? )
            {
            // InternalSolidity.g:1454:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )? )
            // InternalSolidity.g:1455:3: this_LogicalOrExpression_0= ruleLogicalOrExpression ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConditionalExpressionAccess().getLogicalOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_30);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1463:3: ( () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==42) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalSolidity.g:1464:4: () otherlv_2= '?' ( (lv_trueCase_3_0= ruleLogicalOrExpression ) ) otherlv_4= ':' ( (lv_falseCase_5_0= ruleLogicalOrExpression ) )
                    {
                    // InternalSolidity.g:1464:4: ()
                    // InternalSolidity.g:1465:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getConditionalExpressionAccess().getConditionalExpressionConditionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_2=(Token)match(input,42,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getConditionalExpressionAccess().getQuestionMarkKeyword_1_1());
                      			
                    }
                    // InternalSolidity.g:1475:4: ( (lv_trueCase_3_0= ruleLogicalOrExpression ) )
                    // InternalSolidity.g:1476:5: (lv_trueCase_3_0= ruleLogicalOrExpression )
                    {
                    // InternalSolidity.g:1476:5: (lv_trueCase_3_0= ruleLogicalOrExpression )
                    // InternalSolidity.g:1477:6: lv_trueCase_3_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getConditionalExpressionAccess().getTrueCaseLogicalOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
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

                    otherlv_4=(Token)match(input,39,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getConditionalExpressionAccess().getColonKeyword_1_3());
                      			
                    }
                    // InternalSolidity.g:1498:4: ( (lv_falseCase_5_0= ruleLogicalOrExpression ) )
                    // InternalSolidity.g:1499:5: (lv_falseCase_5_0= ruleLogicalOrExpression )
                    {
                    // InternalSolidity.g:1499:5: (lv_falseCase_5_0= ruleLogicalOrExpression )
                    // InternalSolidity.g:1500:6: lv_falseCase_5_0= ruleLogicalOrExpression
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
    // InternalSolidity.g:1522:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalSolidity.g:1522:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalSolidity.g:1523:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalSolidity.g:1529:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1535:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalSolidity.g:1536:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalSolidity.g:1536:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalSolidity.g:1537:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1545:3: ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==50) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalSolidity.g:1546:4: () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalSolidity.g:1546:4: ()
            	    // InternalSolidity.g:1547:5: 
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
            	    pushFollow(FOLLOW_15);
            	    ruleLogicalOrOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalSolidity.g:1560:4: ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    // InternalSolidity.g:1561:5: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalSolidity.g:1561:5: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    // InternalSolidity.g:1562:6: lv_rightOperand_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_31);
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
    // InternalSolidity.g:1584:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalSolidity.g:1584:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalSolidity.g:1585:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalSolidity.g:1591:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalNotExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1597:2: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) )
            // InternalSolidity.g:1598:2: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            {
            // InternalSolidity.g:1598:2: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            // InternalSolidity.g:1599:3: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_32);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalNotExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1607:3: ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==49) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSolidity.g:1608:4: () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    {
            	    // InternalSolidity.g:1608:4: ()
            	    // InternalSolidity.g:1609:5: 
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
            	    pushFollow(FOLLOW_15);
            	    ruleLogicalAndOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalSolidity.g:1622:4: ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    // InternalSolidity.g:1623:5: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    {
            	    // InternalSolidity.g:1623:5: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    // InternalSolidity.g:1624:6: lv_rightOperand_3_0= ruleLogicalNotExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
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
    // InternalSolidity.g:1646:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // InternalSolidity.g:1646:61: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // InternalSolidity.g:1647:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
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
    // InternalSolidity.g:1653:1: ruleLogicalNotExpression returns [EObject current=null] : (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BitwiseXorExpression_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1659:2: ( (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) ) )
            // InternalSolidity.g:1660:2: (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) )
            {
            // InternalSolidity.g:1660:2: (this_BitwiseXorExpression_0= ruleBitwiseXorExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_STRING && LA26_0<=RULE_BINARY)||LA26_0==29||LA26_0==31||LA26_0==48||(LA26_0>=71 && LA26_0<=72)||LA26_0==76) ) {
                alt26=1;
            }
            else if ( (LA26_0==51) ) {
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
                    // InternalSolidity.g:1661:3: this_BitwiseXorExpression_0= ruleBitwiseXorExpression
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
                    // InternalSolidity.g:1670:3: ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) )
                    {
                    // InternalSolidity.g:1670:3: ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) ) )
                    // InternalSolidity.g:1671:4: () ruleLogicalNotOperator ( (lv_operand_3_0= ruleBitwiseXorExpression ) )
                    {
                    // InternalSolidity.g:1671:4: ()
                    // InternalSolidity.g:1672:5: 
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
                    pushFollow(FOLLOW_33);
                    ruleLogicalNotOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalSolidity.g:1685:4: ( (lv_operand_3_0= ruleBitwiseXorExpression ) )
                    // InternalSolidity.g:1686:5: (lv_operand_3_0= ruleBitwiseXorExpression )
                    {
                    // InternalSolidity.g:1686:5: (lv_operand_3_0= ruleBitwiseXorExpression )
                    // InternalSolidity.g:1687:6: lv_operand_3_0= ruleBitwiseXorExpression
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
    // InternalSolidity.g:1709:1: entryRuleBitwiseXorExpression returns [EObject current=null] : iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF ;
    public final EObject entryRuleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseXorExpression = null;


        try {
            // InternalSolidity.g:1709:61: (iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF )
            // InternalSolidity.g:1710:2: iv_ruleBitwiseXorExpression= ruleBitwiseXorExpression EOF
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
    // InternalSolidity.g:1716:1: ruleBitwiseXorExpression returns [EObject current=null] : (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* ) ;
    public final EObject ruleBitwiseXorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BitwiseOrExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1722:2: ( (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* ) )
            // InternalSolidity.g:1723:2: (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* )
            {
            // InternalSolidity.g:1723:2: (this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )* )
            // InternalSolidity.g:1724:3: this_BitwiseOrExpression_0= ruleBitwiseOrExpression ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getBitwiseOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_34);
            this_BitwiseOrExpression_0=ruleBitwiseOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitwiseOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1732:3: ( () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==52) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalSolidity.g:1733:4: () ruleBitwiseXOrOperator ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) )
            	    {
            	    // InternalSolidity.g:1733:4: ()
            	    // InternalSolidity.g:1734:5: 
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
            	    pushFollow(FOLLOW_33);
            	    ruleBitwiseXOrOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalSolidity.g:1747:4: ( (lv_rightOperand_3_0= ruleBitwiseOrExpression ) )
            	    // InternalSolidity.g:1748:5: (lv_rightOperand_3_0= ruleBitwiseOrExpression )
            	    {
            	    // InternalSolidity.g:1748:5: (lv_rightOperand_3_0= ruleBitwiseOrExpression )
            	    // InternalSolidity.g:1749:6: lv_rightOperand_3_0= ruleBitwiseOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitwiseXorExpressionAccess().getRightOperandBitwiseOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
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
    // InternalSolidity.g:1771:1: entryRuleBitwiseOrExpression returns [EObject current=null] : iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF ;
    public final EObject entryRuleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseOrExpression = null;


        try {
            // InternalSolidity.g:1771:60: (iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF )
            // InternalSolidity.g:1772:2: iv_ruleBitwiseOrExpression= ruleBitwiseOrExpression EOF
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
    // InternalSolidity.g:1778:1: ruleBitwiseOrExpression returns [EObject current=null] : (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* ) ;
    public final EObject ruleBitwiseOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BitwiseAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1784:2: ( (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* ) )
            // InternalSolidity.g:1785:2: (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* )
            {
            // InternalSolidity.g:1785:2: (this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )* )
            // InternalSolidity.g:1786:3: this_BitwiseAndExpression_0= ruleBitwiseAndExpression ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getBitwiseAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_35);
            this_BitwiseAndExpression_0=ruleBitwiseAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitwiseAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1794:3: ( () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==53) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalSolidity.g:1795:4: () ruleBitwiseOrOperator ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) )
            	    {
            	    // InternalSolidity.g:1795:4: ()
            	    // InternalSolidity.g:1796:5: 
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
            	    pushFollow(FOLLOW_33);
            	    ruleBitwiseOrOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalSolidity.g:1809:4: ( (lv_rightOperand_3_0= ruleBitwiseAndExpression ) )
            	    // InternalSolidity.g:1810:5: (lv_rightOperand_3_0= ruleBitwiseAndExpression )
            	    {
            	    // InternalSolidity.g:1810:5: (lv_rightOperand_3_0= ruleBitwiseAndExpression )
            	    // InternalSolidity.g:1811:6: lv_rightOperand_3_0= ruleBitwiseAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitwiseOrExpressionAccess().getRightOperandBitwiseAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
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
    // InternalSolidity.g:1833:1: entryRuleBitwiseAndExpression returns [EObject current=null] : iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF ;
    public final EObject entryRuleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitwiseAndExpression = null;


        try {
            // InternalSolidity.g:1833:61: (iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF )
            // InternalSolidity.g:1834:2: iv_ruleBitwiseAndExpression= ruleBitwiseAndExpression EOF
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
    // InternalSolidity.g:1840:1: ruleBitwiseAndExpression returns [EObject current=null] : (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* ) ;
    public final EObject ruleBitwiseAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalRelationExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1846:2: ( (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* ) )
            // InternalSolidity.g:1847:2: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* )
            {
            // InternalSolidity.g:1847:2: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )* )
            // InternalSolidity.g:1848:3: this_LogicalRelationExpression_0= ruleLogicalRelationExpression ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getLogicalRelationExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_36);
            this_LogicalRelationExpression_0=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalRelationExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1856:3: ( () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==54) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalSolidity.g:1857:4: () ruleBitwiseAndOperator ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) )
            	    {
            	    // InternalSolidity.g:1857:4: ()
            	    // InternalSolidity.g:1858:5: 
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
            	    pushFollow(FOLLOW_33);
            	    ruleBitwiseAndOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalSolidity.g:1871:4: ( (lv_rightOperand_3_0= ruleLogicalRelationExpression ) )
            	    // InternalSolidity.g:1872:5: (lv_rightOperand_3_0= ruleLogicalRelationExpression )
            	    {
            	    // InternalSolidity.g:1872:5: (lv_rightOperand_3_0= ruleLogicalRelationExpression )
            	    // InternalSolidity.g:1873:6: lv_rightOperand_3_0= ruleLogicalRelationExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitwiseAndExpressionAccess().getRightOperandLogicalRelationExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
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
    // InternalSolidity.g:1895:1: entryRuleLogicalRelationExpression returns [EObject current=null] : iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF ;
    public final EObject entryRuleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalRelationExpression = null;


        try {
            // InternalSolidity.g:1895:66: (iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF )
            // InternalSolidity.g:1896:2: iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF
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
    // InternalSolidity.g:1902:1: ruleLogicalRelationExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1908:2: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* ) )
            // InternalSolidity.g:1909:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* )
            {
            // InternalSolidity.g:1909:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )* )
            // InternalSolidity.g:1910:3: this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_37);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1918:3: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=46 && LA30_0<=47)||(LA30_0>=77 && LA30_0<=80)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalSolidity.g:1919:4: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalSolidity.g:1919:4: ()
            	    // InternalSolidity.g:1920:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalSolidity.g:1926:4: ( (lv_operator_2_0= ruleRelationalOperator ) )
            	    // InternalSolidity.g:1927:5: (lv_operator_2_0= ruleRelationalOperator )
            	    {
            	    // InternalSolidity.g:1927:5: (lv_operator_2_0= ruleRelationalOperator )
            	    // InternalSolidity.g:1928:6: lv_operator_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
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

            	    // InternalSolidity.g:1945:4: ( (lv_rightOperand_3_0= ruleShiftExpression ) )
            	    // InternalSolidity.g:1946:5: (lv_rightOperand_3_0= ruleShiftExpression )
            	    {
            	    // InternalSolidity.g:1946:5: (lv_rightOperand_3_0= ruleShiftExpression )
            	    // InternalSolidity.g:1947:6: lv_rightOperand_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandShiftExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
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
    // InternalSolidity.g:1969:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalSolidity.g:1969:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalSolidity.g:1970:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalSolidity.g:1976:1: ruleShiftExpression returns [EObject current=null] : (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalAddSubtractExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:1982:2: ( (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* ) )
            // InternalSolidity.g:1983:2: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            {
            // InternalSolidity.g:1983:2: (this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )* )
            // InternalSolidity.g:1984:3: this_NumericalAddSubtractExpression_0= ruleNumericalAddSubtractExpression ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getNumericalAddSubtractExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_38);
            this_NumericalAddSubtractExpression_0=ruleNumericalAddSubtractExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_NumericalAddSubtractExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:1992:3: ( () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=69 && LA31_0<=70)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalSolidity.g:1993:4: () ( (lv_operator_2_0= ruleShiftOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    {
            	    // InternalSolidity.g:1993:4: ()
            	    // InternalSolidity.g:1994:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalSolidity.g:2000:4: ( (lv_operator_2_0= ruleShiftOperator ) )
            	    // InternalSolidity.g:2001:5: (lv_operator_2_0= ruleShiftOperator )
            	    {
            	    // InternalSolidity.g:2001:5: (lv_operator_2_0= ruleShiftOperator )
            	    // InternalSolidity.g:2002:6: lv_operator_2_0= ruleShiftOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getOperatorShiftOperatorEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
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

            	    // InternalSolidity.g:2019:4: ( (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression ) )
            	    // InternalSolidity.g:2020:5: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    {
            	    // InternalSolidity.g:2020:5: (lv_rightOperand_3_0= ruleNumericalAddSubtractExpression )
            	    // InternalSolidity.g:2021:6: lv_rightOperand_3_0= ruleNumericalAddSubtractExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightOperandNumericalAddSubtractExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
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
    // InternalSolidity.g:2043:1: entryRuleNumericalAddSubtractExpression returns [EObject current=null] : iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF ;
    public final EObject entryRuleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalAddSubtractExpression = null;


        try {
            // InternalSolidity.g:2043:71: (iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF )
            // InternalSolidity.g:2044:2: iv_ruleNumericalAddSubtractExpression= ruleNumericalAddSubtractExpression EOF
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
    // InternalSolidity.g:2050:1: ruleNumericalAddSubtractExpression returns [EObject current=null] : (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )* ) ;
    public final EObject ruleNumericalAddSubtractExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalMultiplyDivideExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2056:2: ( (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )* ) )
            // InternalSolidity.g:2057:2: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )* )
            {
            // InternalSolidity.g:2057:2: (this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )* )
            // InternalSolidity.g:2058:3: this_NumericalMultiplyDivideExpression_0= ruleNumericalMultiplyDivideExpression ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalMultiplyDivideExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_39);
            this_NumericalMultiplyDivideExpression_0=ruleNumericalMultiplyDivideExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_NumericalMultiplyDivideExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:2066:3: ( ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==71) && (synpred1_InternalSolidity())) {
                    alt32=1;
                }
                else if ( (LA32_0==72) && (synpred1_InternalSolidity())) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalSolidity.g:2067:4: ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )
            	    {
            	    // InternalSolidity.g:2082:4: ( () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) ) )
            	    // InternalSolidity.g:2083:5: () ( (lv_operator_2_0= ruleAdditiveOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    {
            	    // InternalSolidity.g:2083:5: ()
            	    // InternalSolidity.g:2084:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getNumericalAddSubtractExpressionAccess().getNumericalAddSubtractExpressionLeftOperandAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalSolidity.g:2090:5: ( (lv_operator_2_0= ruleAdditiveOperator ) )
            	    // InternalSolidity.g:2091:6: (lv_operator_2_0= ruleAdditiveOperator )
            	    {
            	    // InternalSolidity.g:2091:6: (lv_operator_2_0= ruleAdditiveOperator )
            	    // InternalSolidity.g:2092:7: lv_operator_2_0= ruleAdditiveOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getOperatorAdditiveOperatorEnumRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_33);
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

            	    // InternalSolidity.g:2109:5: ( (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression ) )
            	    // InternalSolidity.g:2110:6: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    {
            	    // InternalSolidity.g:2110:6: (lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression )
            	    // InternalSolidity.g:2111:7: lv_rightOperand_3_0= ruleNumericalMultiplyDivideExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getNumericalAddSubtractExpressionAccess().getRightOperandNumericalMultiplyDivideExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_39);
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
    // InternalSolidity.g:2134:1: entryRuleNumericalMultiplyDivideExpression returns [EObject current=null] : iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF ;
    public final EObject entryRuleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalMultiplyDivideExpression = null;


        try {
            // InternalSolidity.g:2134:74: (iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF )
            // InternalSolidity.g:2135:2: iv_ruleNumericalMultiplyDivideExpression= ruleNumericalMultiplyDivideExpression EOF
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
    // InternalSolidity.g:2141:1: ruleNumericalMultiplyDivideExpression returns [EObject current=null] : (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )* ) ;
    public final EObject ruleNumericalMultiplyDivideExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalUnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2147:2: ( (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )* ) )
            // InternalSolidity.g:2148:2: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )* )
            {
            // InternalSolidity.g:2148:2: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )* )
            // InternalSolidity.g:2149:3: this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_40);
            this_NumericalUnaryExpression_0=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_NumericalUnaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:2157:3: ( ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==73) && (synpred2_InternalSolidity())) {
                    alt33=1;
                }
                else if ( (LA33_0==74) && (synpred2_InternalSolidity())) {
                    alt33=1;
                }
                else if ( (LA33_0==75) && (synpred2_InternalSolidity())) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalSolidity.g:2158:4: ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )
            	    {
            	    // InternalSolidity.g:2173:4: ( () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) ) )
            	    // InternalSolidity.g:2174:5: () ( (lv_operator_2_0= ruleMultiplicativeOperator ) ) ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    {
            	    // InternalSolidity.g:2174:5: ()
            	    // InternalSolidity.g:2175:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getNumericalMultiplyDivideExpressionAccess().getNumericalMultiplyDivideExpressionLeftOperandAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalSolidity.g:2181:5: ( (lv_operator_2_0= ruleMultiplicativeOperator ) )
            	    // InternalSolidity.g:2182:6: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    {
            	    // InternalSolidity.g:2182:6: (lv_operator_2_0= ruleMultiplicativeOperator )
            	    // InternalSolidity.g:2183:7: lv_operator_2_0= ruleMultiplicativeOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getOperatorMultiplicativeOperatorEnumRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_33);
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

            	    // InternalSolidity.g:2200:5: ( (lv_rightOperand_3_0= ruleNumericalUnaryExpression ) )
            	    // InternalSolidity.g:2201:6: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    {
            	    // InternalSolidity.g:2201:6: (lv_rightOperand_3_0= ruleNumericalUnaryExpression )
            	    // InternalSolidity.g:2202:7: lv_rightOperand_3_0= ruleNumericalUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getNumericalMultiplyDivideExpressionAccess().getRightOperandNumericalUnaryExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_40);
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
    // InternalSolidity.g:2225:1: entryRuleNumericalUnaryExpression returns [EObject current=null] : iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF ;
    public final EObject entryRuleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalUnaryExpression = null;


        try {
            // InternalSolidity.g:2225:65: (iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF )
            // InternalSolidity.g:2226:2: iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF
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
    // InternalSolidity.g:2232:1: ruleNumericalUnaryExpression returns [EObject current=null] : (this_TypeCastExpression_0= ruleTypeCastExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) ) ) ;
    public final EObject ruleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_TypeCastExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2238:2: ( (this_TypeCastExpression_0= ruleTypeCastExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) ) ) )
            // InternalSolidity.g:2239:2: (this_TypeCastExpression_0= ruleTypeCastExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) ) )
            {
            // InternalSolidity.g:2239:2: (this_TypeCastExpression_0= ruleTypeCastExpression | ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) ) )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( ((LA34_0>=RULE_STRING && LA34_0<=RULE_BINARY)||LA34_0==29||LA34_0==31||LA34_0==48) ) {
                alt34=1;
            }
            else if ( ((LA34_0>=71 && LA34_0<=72)||LA34_0==76) ) {
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
                    // InternalSolidity.g:2240:3: this_TypeCastExpression_0= ruleTypeCastExpression
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
                    // InternalSolidity.g:2249:3: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) )
                    {
                    // InternalSolidity.g:2249:3: ( () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) ) )
                    // InternalSolidity.g:2250:4: () ( (lv_operator_2_0= ruleUnaryOperator ) ) ( (lv_operand_3_0= ruleTypeCastExpression ) )
                    {
                    // InternalSolidity.g:2250:4: ()
                    // InternalSolidity.g:2251:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSolidity.g:2257:4: ( (lv_operator_2_0= ruleUnaryOperator ) )
                    // InternalSolidity.g:2258:5: (lv_operator_2_0= ruleUnaryOperator )
                    {
                    // InternalSolidity.g:2258:5: (lv_operator_2_0= ruleUnaryOperator )
                    // InternalSolidity.g:2259:6: lv_operator_2_0= ruleUnaryOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorUnaryOperatorEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_41);
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

                    // InternalSolidity.g:2276:4: ( (lv_operand_3_0= ruleTypeCastExpression ) )
                    // InternalSolidity.g:2277:5: (lv_operand_3_0= ruleTypeCastExpression )
                    {
                    // InternalSolidity.g:2277:5: (lv_operand_3_0= ruleTypeCastExpression )
                    // InternalSolidity.g:2278:6: lv_operand_3_0= ruleTypeCastExpression
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
    // InternalSolidity.g:2300:1: entryRuleTypeCastExpression returns [EObject current=null] : iv_ruleTypeCastExpression= ruleTypeCastExpression EOF ;
    public final EObject entryRuleTypeCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeCastExpression = null;


        try {
            // InternalSolidity.g:2300:59: (iv_ruleTypeCastExpression= ruleTypeCastExpression EOF )
            // InternalSolidity.g:2301:2: iv_ruleTypeCastExpression= ruleTypeCastExpression EOF
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
    // InternalSolidity.g:2307:1: ruleTypeCastExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )* ) ;
    public final EObject ruleTypeCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PrimaryExpression_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2313:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )* ) )
            // InternalSolidity.g:2314:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )* )
            {
            // InternalSolidity.g:2314:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )* )
            // InternalSolidity.g:2315:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getTypeCastExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_42);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:2323:3: ( ( () otherlv_2= 'as' ) ( ( ruleQID ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==21) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalSolidity.g:2324:4: ( () otherlv_2= 'as' ) ( ( ruleQID ) )
            	    {
            	    // InternalSolidity.g:2324:4: ( () otherlv_2= 'as' )
            	    // InternalSolidity.g:2325:5: () otherlv_2= 'as'
            	    {
            	    // InternalSolidity.g:2325:5: ()
            	    // InternalSolidity.g:2326:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getTypeCastExpressionAccess().getTypeCastExpressionOperandAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_2=(Token)match(input,21,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getTypeCastExpressionAccess().getAsKeyword_1_0_1());
            	      				
            	    }

            	    }

            	    // InternalSolidity.g:2337:4: ( ( ruleQID ) )
            	    // InternalSolidity.g:2338:5: ( ruleQID )
            	    {
            	    // InternalSolidity.g:2338:5: ( ruleQID )
            	    // InternalSolidity.g:2339:6: ruleQID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getTypeCastExpressionRule());
            	      						}
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getTypeCastExpressionAccess().getTypeTypeCrossReference_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
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
    // InternalSolidity.g:2358:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalSolidity.g:2358:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalSolidity.g:2359:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalSolidity.g:2365:1: rulePrimaryExpression returns [EObject current=null] : (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveValueExpression_0 = null;

        EObject this_FeatureCall_1 = null;

        EObject this_ParenthesizedExpression_2 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2371:2: ( (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression ) )
            // InternalSolidity.g:2372:2: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            {
            // InternalSolidity.g:2372:2: (this_PrimitiveValueExpression_0= rulePrimitiveValueExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression )
            int alt36=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_BOOL:
            case RULE_INT:
            case RULE_DOUBLE:
            case RULE_FLOAT:
            case RULE_HEX:
            case RULE_BINARY:
            case 31:
            case 48:
                {
                alt36=1;
                }
                break;
            case RULE_ID:
                {
                alt36=2;
                }
                break;
            case 29:
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
                    // InternalSolidity.g:2373:3: this_PrimitiveValueExpression_0= rulePrimitiveValueExpression
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
                    // InternalSolidity.g:2382:3: this_FeatureCall_1= ruleFeatureCall
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
                    // InternalSolidity.g:2391:3: this_ParenthesizedExpression_2= ruleParenthesizedExpression
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
    // InternalSolidity.g:2403:1: entryRulePrimitiveValueExpression returns [EObject current=null] : iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF ;
    public final EObject entryRulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveValueExpression = null;


        try {
            // InternalSolidity.g:2403:65: (iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF )
            // InternalSolidity.g:2404:2: iv_rulePrimitiveValueExpression= rulePrimitiveValueExpression EOF
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
    // InternalSolidity.g:2410:1: rulePrimitiveValueExpression returns [EObject current=null] : ( () ( (lv_value_1_0= ruleLiteral ) ) ) ;
    public final EObject rulePrimitiveValueExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2416:2: ( ( () ( (lv_value_1_0= ruleLiteral ) ) ) )
            // InternalSolidity.g:2417:2: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            {
            // InternalSolidity.g:2417:2: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            // InternalSolidity.g:2418:3: () ( (lv_value_1_0= ruleLiteral ) )
            {
            // InternalSolidity.g:2418:3: ()
            // InternalSolidity.g:2419:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPrimitiveValueExpressionAccess().getPrimitiveValueExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:2425:3: ( (lv_value_1_0= ruleLiteral ) )
            // InternalSolidity.g:2426:4: (lv_value_1_0= ruleLiteral )
            {
            // InternalSolidity.g:2426:4: (lv_value_1_0= ruleLiteral )
            // InternalSolidity.g:2427:5: lv_value_1_0= ruleLiteral
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
    // InternalSolidity.g:2448:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // InternalSolidity.g:2448:52: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalSolidity.g:2449:2: iv_ruleFeatureCall= ruleFeatureCall EOF
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
    // InternalSolidity.g:2455:1: ruleFeatureCall returns [EObject current=null] : (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* ) ;
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
            // InternalSolidity.g:2461:2: ( (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* ) )
            // InternalSolidity.g:2462:2: (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* )
            {
            // InternalSolidity.g:2462:2: (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* )
            // InternalSolidity.g:2463:3: this_ElementReferenceExpression_0= ruleElementReferenceExpression ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getFeatureCallAccess().getElementReferenceExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_43);
            this_ElementReferenceExpression_0=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ElementReferenceExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSolidity.g:2471:3: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==43) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalSolidity.g:2472:4: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )?
            	    {
            	    // InternalSolidity.g:2472:4: ()
            	    // InternalSolidity.g:2473:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getFeatureCallAccess().getFeatureCallOwnerAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,43,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_1());
            	      			
            	    }
            	    // InternalSolidity.g:2483:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalSolidity.g:2484:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalSolidity.g:2484:5: (otherlv_3= RULE_ID )
            	    // InternalSolidity.g:2485:6: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getFeatureCallRule());
            	      						}
            	      					
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_3, grammarAccess.getFeatureCallAccess().getFeatureEObjectCrossReference_1_2_0());
            	      					
            	    }

            	    }


            	    }

            	    // InternalSolidity.g:2496:4: ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )?
            	    int alt40=3;
            	    int LA40_0 = input.LA(1);

            	    if ( (LA40_0==29) && (synpred3_InternalSolidity())) {
            	        alt40=1;
            	    }
            	    else if ( (LA40_0==44) && (synpred4_InternalSolidity())) {
            	        alt40=2;
            	    }
            	    switch (alt40) {
            	        case 1 :
            	            // InternalSolidity.g:2497:5: ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' )
            	            {
            	            // InternalSolidity.g:2497:5: ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' )
            	            // InternalSolidity.g:2498:6: ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')'
            	            {
            	            // InternalSolidity.g:2498:6: ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) )
            	            // InternalSolidity.g:2499:7: ( ( '(' ) )=> (lv_operationCall_4_0= '(' )
            	            {
            	            // InternalSolidity.g:2503:7: (lv_operationCall_4_0= '(' )
            	            // InternalSolidity.g:2504:8: lv_operationCall_4_0= '('
            	            {
            	            lv_operationCall_4_0=(Token)match(input,29,FOLLOW_45); if (state.failed) return current;
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

            	            // InternalSolidity.g:2516:6: ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )?
            	            int alt38=2;
            	            int LA38_0 = input.LA(1);

            	            if ( ((LA38_0>=RULE_STRING && LA38_0<=RULE_BINARY)||LA38_0==29||LA38_0==31||LA38_0==48||LA38_0==51||(LA38_0>=71 && LA38_0<=72)||LA38_0==76) ) {
            	                alt38=1;
            	            }
            	            switch (alt38) {
            	                case 1 :
            	                    // InternalSolidity.g:2517:7: ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )*
            	                    {
            	                    // InternalSolidity.g:2517:7: ( (lv_arguments_5_0= ruleArgument ) )
            	                    // InternalSolidity.g:2518:8: (lv_arguments_5_0= ruleArgument )
            	                    {
            	                    // InternalSolidity.g:2518:8: (lv_arguments_5_0= ruleArgument )
            	                    // InternalSolidity.g:2519:9: lv_arguments_5_0= ruleArgument
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									newCompositeNode(grammarAccess.getFeatureCallAccess().getArgumentsArgumentParserRuleCall_1_3_0_1_0_0());
            	                      								
            	                    }
            	                    pushFollow(FOLLOW_20);
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

            	                    // InternalSolidity.g:2536:7: (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )*
            	                    loop37:
            	                    do {
            	                        int alt37=2;
            	                        int LA37_0 = input.LA(1);

            	                        if ( (LA37_0==23) ) {
            	                            alt37=1;
            	                        }


            	                        switch (alt37) {
            	                    	case 1 :
            	                    	    // InternalSolidity.g:2537:8: otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) )
            	                    	    {
            	                    	    otherlv_6=(Token)match(input,23,FOLLOW_15); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      								newLeafNode(otherlv_6, grammarAccess.getFeatureCallAccess().getCommaKeyword_1_3_0_1_1_0());
            	                    	      							
            	                    	    }
            	                    	    // InternalSolidity.g:2541:8: ( (lv_arguments_7_0= ruleArgument ) )
            	                    	    // InternalSolidity.g:2542:9: (lv_arguments_7_0= ruleArgument )
            	                    	    {
            	                    	    // InternalSolidity.g:2542:9: (lv_arguments_7_0= ruleArgument )
            	                    	    // InternalSolidity.g:2543:10: lv_arguments_7_0= ruleArgument
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      										newCompositeNode(grammarAccess.getFeatureCallAccess().getArgumentsArgumentParserRuleCall_1_3_0_1_1_1_0());
            	                    	      									
            	                    	    }
            	                    	    pushFollow(FOLLOW_20);
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

            	            otherlv_8=(Token)match(input,30,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_8, grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_3_0_2());
            	              					
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalSolidity.g:2568:5: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* )
            	            {
            	            // InternalSolidity.g:2568:5: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* )
            	            // InternalSolidity.g:2569:6: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )*
            	            {
            	            // InternalSolidity.g:2569:6: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) )
            	            // InternalSolidity.g:2570:7: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' )
            	            {
            	            // InternalSolidity.g:2584:7: ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' )
            	            // InternalSolidity.g:2585:8: ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']'
            	            {
            	            // InternalSolidity.g:2585:8: ( (lv_arrayAccess_9_0= '[' ) )
            	            // InternalSolidity.g:2586:9: (lv_arrayAccess_9_0= '[' )
            	            {
            	            // InternalSolidity.g:2586:9: (lv_arrayAccess_9_0= '[' )
            	            // InternalSolidity.g:2587:10: lv_arrayAccess_9_0= '['
            	            {
            	            lv_arrayAccess_9_0=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
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

            	            // InternalSolidity.g:2599:8: ( (lv_arraySelector_10_0= ruleExpression ) )
            	            // InternalSolidity.g:2600:9: (lv_arraySelector_10_0= ruleExpression )
            	            {
            	            // InternalSolidity.g:2600:9: (lv_arraySelector_10_0= ruleExpression )
            	            // InternalSolidity.g:2601:10: lv_arraySelector_10_0= ruleExpression
            	            {
            	            if ( state.backtracking==0 ) {

            	              										newCompositeNode(grammarAccess.getFeatureCallAccess().getArraySelectorExpressionParserRuleCall_1_3_1_0_0_1_0());
            	              									
            	            }
            	            pushFollow(FOLLOW_46);
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

            	            otherlv_11=(Token)match(input,45,FOLLOW_47); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(otherlv_11, grammarAccess.getFeatureCallAccess().getRightSquareBracketKeyword_1_3_1_0_0_2());
            	              							
            	            }

            	            }


            	            }

            	            // InternalSolidity.g:2624:6: ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )*
            	            loop39:
            	            do {
            	                int alt39=2;
            	                int LA39_0 = input.LA(1);

            	                if ( (LA39_0==44) && (synpred5_InternalSolidity())) {
            	                    alt39=1;
            	                }


            	                switch (alt39) {
            	            	case 1 :
            	            	    // InternalSolidity.g:2625:7: ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' )
            	            	    {
            	            	    // InternalSolidity.g:2635:7: (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' )
            	            	    // InternalSolidity.g:2636:8: otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']'
            	            	    {
            	            	    otherlv_12=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      								newLeafNode(otherlv_12, grammarAccess.getFeatureCallAccess().getLeftSquareBracketKeyword_1_3_1_1_0_0());
            	            	      							
            	            	    }
            	            	    // InternalSolidity.g:2640:8: ( (lv_arraySelector_13_0= ruleExpression ) )
            	            	    // InternalSolidity.g:2641:9: (lv_arraySelector_13_0= ruleExpression )
            	            	    {
            	            	    // InternalSolidity.g:2641:9: (lv_arraySelector_13_0= ruleExpression )
            	            	    // InternalSolidity.g:2642:10: lv_arraySelector_13_0= ruleExpression
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      										newCompositeNode(grammarAccess.getFeatureCallAccess().getArraySelectorExpressionParserRuleCall_1_3_1_1_0_1_0());
            	            	      									
            	            	    }
            	            	    pushFollow(FOLLOW_46);
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

            	            	    otherlv_14=(Token)match(input,45,FOLLOW_47); if (state.failed) return current;
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
    // InternalSolidity.g:2672:1: entryRuleElementReferenceExpression returns [EObject current=null] : iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF ;
    public final EObject entryRuleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementReferenceExpression = null;


        try {
            // InternalSolidity.g:2672:67: (iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF )
            // InternalSolidity.g:2673:2: iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF
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
    // InternalSolidity.g:2679:1: ruleElementReferenceExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )? ) ;
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
            // InternalSolidity.g:2685:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )? ) )
            // InternalSolidity.g:2686:2: ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )? )
            {
            // InternalSolidity.g:2686:2: ( () ( (otherlv_1= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )? )
            // InternalSolidity.g:2687:3: () ( (otherlv_1= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )?
            {
            // InternalSolidity.g:2687:3: ()
            // InternalSolidity.g:2688:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getElementReferenceExpressionAccess().getElementReferenceExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:2694:3: ( (otherlv_1= RULE_ID ) )
            // InternalSolidity.g:2695:4: (otherlv_1= RULE_ID )
            {
            // InternalSolidity.g:2695:4: (otherlv_1= RULE_ID )
            // InternalSolidity.g:2696:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getElementReferenceExpressionAccess().getReferenceEObjectCrossReference_1_0());
              				
            }

            }


            }

            // InternalSolidity.g:2707:3: ( ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* ) )?
            int alt45=3;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==29) && (synpred6_InternalSolidity())) {
                alt45=1;
            }
            else if ( (LA45_0==44) && (synpred7_InternalSolidity())) {
                alt45=2;
            }
            switch (alt45) {
                case 1 :
                    // InternalSolidity.g:2708:4: ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' )
                    {
                    // InternalSolidity.g:2708:4: ( ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')' )
                    // InternalSolidity.g:2709:5: ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) ) ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )? otherlv_6= ')'
                    {
                    // InternalSolidity.g:2709:5: ( ( ( '(' ) )=> (lv_operationCall_2_0= '(' ) )
                    // InternalSolidity.g:2710:6: ( ( '(' ) )=> (lv_operationCall_2_0= '(' )
                    {
                    // InternalSolidity.g:2714:6: (lv_operationCall_2_0= '(' )
                    // InternalSolidity.g:2715:7: lv_operationCall_2_0= '('
                    {
                    lv_operationCall_2_0=(Token)match(input,29,FOLLOW_45); if (state.failed) return current;
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

                    // InternalSolidity.g:2727:5: ( ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )* )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( ((LA43_0>=RULE_STRING && LA43_0<=RULE_BINARY)||LA43_0==29||LA43_0==31||LA43_0==48||LA43_0==51||(LA43_0>=71 && LA43_0<=72)||LA43_0==76) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalSolidity.g:2728:6: ( (lv_arguments_3_0= ruleArgument ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )*
                            {
                            // InternalSolidity.g:2728:6: ( (lv_arguments_3_0= ruleArgument ) )
                            // InternalSolidity.g:2729:7: (lv_arguments_3_0= ruleArgument )
                            {
                            // InternalSolidity.g:2729:7: (lv_arguments_3_0= ruleArgument )
                            // InternalSolidity.g:2730:8: lv_arguments_3_0= ruleArgument
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArgumentsArgumentParserRuleCall_2_0_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_20);
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

                            // InternalSolidity.g:2747:6: (otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) ) )*
                            loop42:
                            do {
                                int alt42=2;
                                int LA42_0 = input.LA(1);

                                if ( (LA42_0==23) ) {
                                    alt42=1;
                                }


                                switch (alt42) {
                            	case 1 :
                            	    // InternalSolidity.g:2748:7: otherlv_4= ',' ( (lv_arguments_5_0= ruleArgument ) )
                            	    {
                            	    otherlv_4=(Token)match(input,23,FOLLOW_15); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_4, grammarAccess.getElementReferenceExpressionAccess().getCommaKeyword_2_0_1_1_0());
                            	      						
                            	    }
                            	    // InternalSolidity.g:2752:7: ( (lv_arguments_5_0= ruleArgument ) )
                            	    // InternalSolidity.g:2753:8: (lv_arguments_5_0= ruleArgument )
                            	    {
                            	    // InternalSolidity.g:2753:8: (lv_arguments_5_0= ruleArgument )
                            	    // InternalSolidity.g:2754:9: lv_arguments_5_0= ruleArgument
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArgumentsArgumentParserRuleCall_2_0_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_20);
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

                    otherlv_6=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getElementReferenceExpressionAccess().getRightParenthesisKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:2779:4: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* )
                    {
                    // InternalSolidity.g:2779:4: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )* )
                    // InternalSolidity.g:2780:5: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )*
                    {
                    // InternalSolidity.g:2780:5: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' ) )
                    // InternalSolidity.g:2781:6: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' )
                    {
                    // InternalSolidity.g:2795:6: ( ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']' )
                    // InternalSolidity.g:2796:7: ( (lv_arrayAccess_7_0= '[' ) ) ( (lv_arraySelector_8_0= ruleExpression ) ) otherlv_9= ']'
                    {
                    // InternalSolidity.g:2796:7: ( (lv_arrayAccess_7_0= '[' ) )
                    // InternalSolidity.g:2797:8: (lv_arrayAccess_7_0= '[' )
                    {
                    // InternalSolidity.g:2797:8: (lv_arrayAccess_7_0= '[' )
                    // InternalSolidity.g:2798:9: lv_arrayAccess_7_0= '['
                    {
                    lv_arrayAccess_7_0=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
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

                    // InternalSolidity.g:2810:7: ( (lv_arraySelector_8_0= ruleExpression ) )
                    // InternalSolidity.g:2811:8: (lv_arraySelector_8_0= ruleExpression )
                    {
                    // InternalSolidity.g:2811:8: (lv_arraySelector_8_0= ruleExpression )
                    // InternalSolidity.g:2812:9: lv_arraySelector_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      									newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArraySelectorExpressionParserRuleCall_2_1_0_0_1_0());
                      								
                    }
                    pushFollow(FOLLOW_46);
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

                    otherlv_9=(Token)match(input,45,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_9, grammarAccess.getElementReferenceExpressionAccess().getRightSquareBracketKeyword_2_1_0_0_2());
                      						
                    }

                    }


                    }

                    // InternalSolidity.g:2835:5: ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==44) && (synpred8_InternalSolidity())) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalSolidity.g:2836:6: ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' )
                    	    {
                    	    // InternalSolidity.g:2846:6: (otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']' )
                    	    // InternalSolidity.g:2847:7: otherlv_10= '[' ( (lv_arraySelector_11_0= ruleExpression ) ) otherlv_12= ']'
                    	    {
                    	    otherlv_10=(Token)match(input,44,FOLLOW_15); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_10, grammarAccess.getElementReferenceExpressionAccess().getLeftSquareBracketKeyword_2_1_1_0_0());
                    	      						
                    	    }
                    	    // InternalSolidity.g:2851:7: ( (lv_arraySelector_11_0= ruleExpression ) )
                    	    // InternalSolidity.g:2852:8: (lv_arraySelector_11_0= ruleExpression )
                    	    {
                    	    // InternalSolidity.g:2852:8: (lv_arraySelector_11_0= ruleExpression )
                    	    // InternalSolidity.g:2853:9: lv_arraySelector_11_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArraySelectorExpressionParserRuleCall_2_1_1_0_1_0());
                    	      								
                    	    }
                    	    pushFollow(FOLLOW_46);
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

                    	    otherlv_12=(Token)match(input,45,FOLLOW_49); if (state.failed) return current;
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
    // InternalSolidity.g:2882:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalSolidity.g:2882:49: (iv_ruleArgument= ruleArgument EOF )
            // InternalSolidity.g:2883:2: iv_ruleArgument= ruleArgument EOF
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
    // InternalSolidity.g:2889:1: ruleArgument returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_value_2_0= ruleConditionalExpression ) ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2895:2: ( ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_value_2_0= ruleConditionalExpression ) ) ) )
            // InternalSolidity.g:2896:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_value_2_0= ruleConditionalExpression ) ) )
            {
            // InternalSolidity.g:2896:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_value_2_0= ruleConditionalExpression ) ) )
            // InternalSolidity.g:2897:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )? ( (lv_value_2_0= ruleConditionalExpression ) )
            {
            // InternalSolidity.g:2897:3: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' )?
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
                    // InternalSolidity.g:2898:4: ( (otherlv_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // InternalSolidity.g:2898:4: ( (otherlv_0= RULE_ID ) )
                    // InternalSolidity.g:2899:5: (otherlv_0= RULE_ID )
                    {
                    // InternalSolidity.g:2899:5: (otherlv_0= RULE_ID )
                    // InternalSolidity.g:2900:6: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getArgumentRule());
                      						}
                      					
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_0, grammarAccess.getArgumentAccess().getParameterParameterCrossReference_0_0_0());
                      					
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,26,FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getArgumentAccess().getEqualsSignKeyword_0_1());
                      			
                    }

                    }
                    break;

            }

            // InternalSolidity.g:2916:3: ( (lv_value_2_0= ruleConditionalExpression ) )
            // InternalSolidity.g:2917:4: (lv_value_2_0= ruleConditionalExpression )
            {
            // InternalSolidity.g:2917:4: (lv_value_2_0= ruleConditionalExpression )
            // InternalSolidity.g:2918:5: lv_value_2_0= ruleConditionalExpression
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
    // InternalSolidity.g:2939:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // InternalSolidity.g:2939:64: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // InternalSolidity.g:2940:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
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
    // InternalSolidity.g:2946:1: ruleParenthesizedExpression returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:2952:2: ( ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalSolidity.g:2953:2: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalSolidity.g:2953:2: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalSolidity.g:2954:3: () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            // InternalSolidity.g:2954:3: ()
            // InternalSolidity.g:2955:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParenthesizedExpressionAccess().getParenthesizedExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,29,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalSolidity.g:2965:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalSolidity.g:2966:4: (lv_expression_2_0= ruleExpression )
            {
            // InternalSolidity.g:2966:4: (lv_expression_2_0= ruleExpression )
            // InternalSolidity.g:2967:5: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_51);
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

            otherlv_3=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:2992:1: entryRuleTypeSpecifier returns [EObject current=null] : iv_ruleTypeSpecifier= ruleTypeSpecifier EOF ;
    public final EObject entryRuleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeSpecifier = null;


        try {
            // InternalSolidity.g:2992:54: (iv_ruleTypeSpecifier= ruleTypeSpecifier EOF )
            // InternalSolidity.g:2993:2: iv_ruleTypeSpecifier= ruleTypeSpecifier EOF
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
    // InternalSolidity.g:2999:1: ruleTypeSpecifier returns [EObject current=null] : ( ( ( ruleQID ) ) (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )? ) ;
    public final EObject ruleTypeSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_typeArguments_2_0 = null;

        EObject lv_typeArguments_4_0 = null;



        	enterRule();

        try {
            // InternalSolidity.g:3005:2: ( ( ( ( ruleQID ) ) (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )? ) )
            // InternalSolidity.g:3006:2: ( ( ( ruleQID ) ) (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )? )
            {
            // InternalSolidity.g:3006:2: ( ( ( ruleQID ) ) (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )? )
            // InternalSolidity.g:3007:3: ( ( ruleQID ) ) (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )?
            {
            // InternalSolidity.g:3007:3: ( ( ruleQID ) )
            // InternalSolidity.g:3008:4: ( ruleQID )
            {
            // InternalSolidity.g:3008:4: ( ruleQID )
            // InternalSolidity.g:3009:5: ruleQID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypeSpecifierRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeSpecifierAccess().getTypeTypeCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_52);
            ruleQID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSolidity.g:3023:3: (otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==46) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalSolidity.g:3024:4: otherlv_1= '<' ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' )
                    {
                    otherlv_1=(Token)match(input,46,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeSpecifierAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalSolidity.g:3028:4: ( ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>' )
                    // InternalSolidity.g:3029:5: ( (lv_typeArguments_2_0= ruleTypeSpecifier ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )* otherlv_5= '>'
                    {
                    // InternalSolidity.g:3029:5: ( (lv_typeArguments_2_0= ruleTypeSpecifier ) )
                    // InternalSolidity.g:3030:6: (lv_typeArguments_2_0= ruleTypeSpecifier )
                    {
                    // InternalSolidity.g:3030:6: (lv_typeArguments_2_0= ruleTypeSpecifier )
                    // InternalSolidity.g:3031:7: lv_typeArguments_2_0= ruleTypeSpecifier
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getTypeSpecifierAccess().getTypeArgumentsTypeSpecifierParserRuleCall_1_1_0_0());
                      						
                    }
                    pushFollow(FOLLOW_53);
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

                    // InternalSolidity.g:3048:5: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==23) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // InternalSolidity.g:3049:6: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleTypeSpecifier ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_9); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(otherlv_3, grammarAccess.getTypeSpecifierAccess().getCommaKeyword_1_1_1_0());
                    	      					
                    	    }
                    	    // InternalSolidity.g:3053:6: ( (lv_typeArguments_4_0= ruleTypeSpecifier ) )
                    	    // InternalSolidity.g:3054:7: (lv_typeArguments_4_0= ruleTypeSpecifier )
                    	    {
                    	    // InternalSolidity.g:3054:7: (lv_typeArguments_4_0= ruleTypeSpecifier )
                    	    // InternalSolidity.g:3055:8: lv_typeArguments_4_0= ruleTypeSpecifier
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      								newCompositeNode(grammarAccess.getTypeSpecifierAccess().getTypeArgumentsTypeSpecifierParserRuleCall_1_1_1_1_0());
                    	      							
                    	    }
                    	    pushFollow(FOLLOW_53);
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

                    otherlv_5=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3083:1: entrySuperLiteral returns [EObject current=null] : iv_superLiteral= superLiteral EOF ;
    public final EObject entrySuperLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_superLiteral = null;


        try {
            // InternalSolidity.g:3083:49: (iv_superLiteral= superLiteral EOF )
            // InternalSolidity.g:3084:2: iv_superLiteral= superLiteral EOF
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
    // InternalSolidity.g:3090:1: superLiteral returns [EObject current=null] : (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_BinaryLiteral_3= ruleBinaryLiteral | this_DoubleLiteral_4= ruleDoubleLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_StringLiteral_6= ruleStringLiteral | this_NullLiteral_7= ruleNullLiteral ) ;
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
            // InternalSolidity.g:3096:2: ( (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_BinaryLiteral_3= ruleBinaryLiteral | this_DoubleLiteral_4= ruleDoubleLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_StringLiteral_6= ruleStringLiteral | this_NullLiteral_7= ruleNullLiteral ) )
            // InternalSolidity.g:3097:2: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_BinaryLiteral_3= ruleBinaryLiteral | this_DoubleLiteral_4= ruleDoubleLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_StringLiteral_6= ruleStringLiteral | this_NullLiteral_7= ruleNullLiteral )
            {
            // InternalSolidity.g:3097:2: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_HexLiteral_2= ruleHexLiteral | this_BinaryLiteral_3= ruleBinaryLiteral | this_DoubleLiteral_4= ruleDoubleLiteral | this_FloatLiteral_5= ruleFloatLiteral | this_StringLiteral_6= ruleStringLiteral | this_NullLiteral_7= ruleNullLiteral )
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
            case 48:
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
                    // InternalSolidity.g:3098:3: this_BoolLiteral_0= ruleBoolLiteral
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
                    // InternalSolidity.g:3107:3: this_IntLiteral_1= ruleIntLiteral
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
                    // InternalSolidity.g:3116:3: this_HexLiteral_2= ruleHexLiteral
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
                    // InternalSolidity.g:3125:3: this_BinaryLiteral_3= ruleBinaryLiteral
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
                    // InternalSolidity.g:3134:3: this_DoubleLiteral_4= ruleDoubleLiteral
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
                    // InternalSolidity.g:3143:3: this_FloatLiteral_5= ruleFloatLiteral
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
                    // InternalSolidity.g:3152:3: this_StringLiteral_6= ruleStringLiteral
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
                    // InternalSolidity.g:3161:3: this_NullLiteral_7= ruleNullLiteral
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
    // InternalSolidity.g:3173:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // InternalSolidity.g:3173:52: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // InternalSolidity.g:3174:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
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
    // InternalSolidity.g:3180:1: ruleBoolLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BOOL ) ) ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3186:2: ( ( () ( (lv_value_1_0= RULE_BOOL ) ) ) )
            // InternalSolidity.g:3187:2: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            {
            // InternalSolidity.g:3187:2: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            // InternalSolidity.g:3188:3: () ( (lv_value_1_0= RULE_BOOL ) )
            {
            // InternalSolidity.g:3188:3: ()
            // InternalSolidity.g:3189:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBoolLiteralAccess().getBoolLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3195:3: ( (lv_value_1_0= RULE_BOOL ) )
            // InternalSolidity.g:3196:4: (lv_value_1_0= RULE_BOOL )
            {
            // InternalSolidity.g:3196:4: (lv_value_1_0= RULE_BOOL )
            // InternalSolidity.g:3197:5: lv_value_1_0= RULE_BOOL
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
    // InternalSolidity.g:3217:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalSolidity.g:3217:51: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalSolidity.g:3218:2: iv_ruleIntLiteral= ruleIntLiteral EOF
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
    // InternalSolidity.g:3224:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_INT ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3230:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) )
            // InternalSolidity.g:3231:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
            {
            // InternalSolidity.g:3231:2: ( () ( (lv_value_1_0= RULE_INT ) ) )
            // InternalSolidity.g:3232:3: () ( (lv_value_1_0= RULE_INT ) )
            {
            // InternalSolidity.g:3232:3: ()
            // InternalSolidity.g:3233:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3239:3: ( (lv_value_1_0= RULE_INT ) )
            // InternalSolidity.g:3240:4: (lv_value_1_0= RULE_INT )
            {
            // InternalSolidity.g:3240:4: (lv_value_1_0= RULE_INT )
            // InternalSolidity.g:3241:5: lv_value_1_0= RULE_INT
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
    // InternalSolidity.g:3261:1: entryRuleDoubleLiteral returns [EObject current=null] : iv_ruleDoubleLiteral= ruleDoubleLiteral EOF ;
    public final EObject entryRuleDoubleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleLiteral = null;


        try {
            // InternalSolidity.g:3261:54: (iv_ruleDoubleLiteral= ruleDoubleLiteral EOF )
            // InternalSolidity.g:3262:2: iv_ruleDoubleLiteral= ruleDoubleLiteral EOF
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
    // InternalSolidity.g:3268:1: ruleDoubleLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_DOUBLE ) ) ) ;
    public final EObject ruleDoubleLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3274:2: ( ( () ( (lv_value_1_0= RULE_DOUBLE ) ) ) )
            // InternalSolidity.g:3275:2: ( () ( (lv_value_1_0= RULE_DOUBLE ) ) )
            {
            // InternalSolidity.g:3275:2: ( () ( (lv_value_1_0= RULE_DOUBLE ) ) )
            // InternalSolidity.g:3276:3: () ( (lv_value_1_0= RULE_DOUBLE ) )
            {
            // InternalSolidity.g:3276:3: ()
            // InternalSolidity.g:3277:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDoubleLiteralAccess().getDoubleLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3283:3: ( (lv_value_1_0= RULE_DOUBLE ) )
            // InternalSolidity.g:3284:4: (lv_value_1_0= RULE_DOUBLE )
            {
            // InternalSolidity.g:3284:4: (lv_value_1_0= RULE_DOUBLE )
            // InternalSolidity.g:3285:5: lv_value_1_0= RULE_DOUBLE
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
    // InternalSolidity.g:3305:1: entryRuleFloatLiteral returns [EObject current=null] : iv_ruleFloatLiteral= ruleFloatLiteral EOF ;
    public final EObject entryRuleFloatLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatLiteral = null;


        try {
            // InternalSolidity.g:3305:53: (iv_ruleFloatLiteral= ruleFloatLiteral EOF )
            // InternalSolidity.g:3306:2: iv_ruleFloatLiteral= ruleFloatLiteral EOF
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
    // InternalSolidity.g:3312:1: ruleFloatLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) ;
    public final EObject ruleFloatLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3318:2: ( ( () ( (lv_value_1_0= RULE_FLOAT ) ) ) )
            // InternalSolidity.g:3319:2: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            {
            // InternalSolidity.g:3319:2: ( () ( (lv_value_1_0= RULE_FLOAT ) ) )
            // InternalSolidity.g:3320:3: () ( (lv_value_1_0= RULE_FLOAT ) )
            {
            // InternalSolidity.g:3320:3: ()
            // InternalSolidity.g:3321:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFloatLiteralAccess().getFloatLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3327:3: ( (lv_value_1_0= RULE_FLOAT ) )
            // InternalSolidity.g:3328:4: (lv_value_1_0= RULE_FLOAT )
            {
            // InternalSolidity.g:3328:4: (lv_value_1_0= RULE_FLOAT )
            // InternalSolidity.g:3329:5: lv_value_1_0= RULE_FLOAT
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
    // InternalSolidity.g:3349:1: entryRuleHexLiteral returns [EObject current=null] : iv_ruleHexLiteral= ruleHexLiteral EOF ;
    public final EObject entryRuleHexLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHexLiteral = null;


        try {
            // InternalSolidity.g:3349:51: (iv_ruleHexLiteral= ruleHexLiteral EOF )
            // InternalSolidity.g:3350:2: iv_ruleHexLiteral= ruleHexLiteral EOF
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
    // InternalSolidity.g:3356:1: ruleHexLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_HEX ) ) ) ;
    public final EObject ruleHexLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3362:2: ( ( () ( (lv_value_1_0= RULE_HEX ) ) ) )
            // InternalSolidity.g:3363:2: ( () ( (lv_value_1_0= RULE_HEX ) ) )
            {
            // InternalSolidity.g:3363:2: ( () ( (lv_value_1_0= RULE_HEX ) ) )
            // InternalSolidity.g:3364:3: () ( (lv_value_1_0= RULE_HEX ) )
            {
            // InternalSolidity.g:3364:3: ()
            // InternalSolidity.g:3365:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getHexLiteralAccess().getHexLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3371:3: ( (lv_value_1_0= RULE_HEX ) )
            // InternalSolidity.g:3372:4: (lv_value_1_0= RULE_HEX )
            {
            // InternalSolidity.g:3372:4: (lv_value_1_0= RULE_HEX )
            // InternalSolidity.g:3373:5: lv_value_1_0= RULE_HEX
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
    // InternalSolidity.g:3393:1: entryRuleBinaryLiteral returns [EObject current=null] : iv_ruleBinaryLiteral= ruleBinaryLiteral EOF ;
    public final EObject entryRuleBinaryLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryLiteral = null;


        try {
            // InternalSolidity.g:3393:54: (iv_ruleBinaryLiteral= ruleBinaryLiteral EOF )
            // InternalSolidity.g:3394:2: iv_ruleBinaryLiteral= ruleBinaryLiteral EOF
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
    // InternalSolidity.g:3400:1: ruleBinaryLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BINARY ) ) ) ;
    public final EObject ruleBinaryLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3406:2: ( ( () ( (lv_value_1_0= RULE_BINARY ) ) ) )
            // InternalSolidity.g:3407:2: ( () ( (lv_value_1_0= RULE_BINARY ) ) )
            {
            // InternalSolidity.g:3407:2: ( () ( (lv_value_1_0= RULE_BINARY ) ) )
            // InternalSolidity.g:3408:3: () ( (lv_value_1_0= RULE_BINARY ) )
            {
            // InternalSolidity.g:3408:3: ()
            // InternalSolidity.g:3409:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBinaryLiteralAccess().getBinaryLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3415:3: ( (lv_value_1_0= RULE_BINARY ) )
            // InternalSolidity.g:3416:4: (lv_value_1_0= RULE_BINARY )
            {
            // InternalSolidity.g:3416:4: (lv_value_1_0= RULE_BINARY )
            // InternalSolidity.g:3417:5: lv_value_1_0= RULE_BINARY
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
    // InternalSolidity.g:3437:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalSolidity.g:3437:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalSolidity.g:3438:2: iv_ruleStringLiteral= ruleStringLiteral EOF
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
    // InternalSolidity.g:3444:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSolidity.g:3450:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalSolidity.g:3451:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalSolidity.g:3451:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalSolidity.g:3452:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalSolidity.g:3452:3: ()
            // InternalSolidity.g:3453:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalSolidity.g:3459:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalSolidity.g:3460:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalSolidity.g:3460:4: (lv_value_1_0= RULE_STRING )
            // InternalSolidity.g:3461:5: lv_value_1_0= RULE_STRING
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
    // InternalSolidity.g:3481:1: entryRuleNullLiteral returns [EObject current=null] : iv_ruleNullLiteral= ruleNullLiteral EOF ;
    public final EObject entryRuleNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteral = null;


        try {
            // InternalSolidity.g:3481:52: (iv_ruleNullLiteral= ruleNullLiteral EOF )
            // InternalSolidity.g:3482:2: iv_ruleNullLiteral= ruleNullLiteral EOF
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
    // InternalSolidity.g:3488:1: ruleNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalSolidity.g:3494:2: ( ( () otherlv_1= 'null' ) )
            // InternalSolidity.g:3495:2: ( () otherlv_1= 'null' )
            {
            // InternalSolidity.g:3495:2: ( () otherlv_1= 'null' )
            // InternalSolidity.g:3496:3: () otherlv_1= 'null'
            {
            // InternalSolidity.g:3496:3: ()
            // InternalSolidity.g:3497:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getNullLiteralAccess().getNullLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3511:1: entryRuleLogicalAndOperator returns [String current=null] : iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF ;
    public final String entryRuleLogicalAndOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalAndOperator = null;


        try {
            // InternalSolidity.g:3511:58: (iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF )
            // InternalSolidity.g:3512:2: iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF
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
    // InternalSolidity.g:3518:1: ruleLogicalAndOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleLogicalAndOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3524:2: (kw= '&&' )
            // InternalSolidity.g:3525:2: kw= '&&'
            {
            kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3533:1: entryRuleLogicalOrOperator returns [String current=null] : iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF ;
    public final String entryRuleLogicalOrOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOrOperator = null;


        try {
            // InternalSolidity.g:3533:57: (iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF )
            // InternalSolidity.g:3534:2: iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF
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
    // InternalSolidity.g:3540:1: ruleLogicalOrOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleLogicalOrOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3546:2: (kw= '||' )
            // InternalSolidity.g:3547:2: kw= '||'
            {
            kw=(Token)match(input,50,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3555:1: entryRuleLogicalNotOperator returns [String current=null] : iv_ruleLogicalNotOperator= ruleLogicalNotOperator EOF ;
    public final String entryRuleLogicalNotOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalNotOperator = null;


        try {
            // InternalSolidity.g:3555:58: (iv_ruleLogicalNotOperator= ruleLogicalNotOperator EOF )
            // InternalSolidity.g:3556:2: iv_ruleLogicalNotOperator= ruleLogicalNotOperator EOF
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
    // InternalSolidity.g:3562:1: ruleLogicalNotOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '!' ;
    public final AntlrDatatypeRuleToken ruleLogicalNotOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3568:2: (kw= '!' )
            // InternalSolidity.g:3569:2: kw= '!'
            {
            kw=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3577:1: entryRuleBitwiseXOrOperator returns [String current=null] : iv_ruleBitwiseXOrOperator= ruleBitwiseXOrOperator EOF ;
    public final String entryRuleBitwiseXOrOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBitwiseXOrOperator = null;


        try {
            // InternalSolidity.g:3577:58: (iv_ruleBitwiseXOrOperator= ruleBitwiseXOrOperator EOF )
            // InternalSolidity.g:3578:2: iv_ruleBitwiseXOrOperator= ruleBitwiseXOrOperator EOF
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
    // InternalSolidity.g:3584:1: ruleBitwiseXOrOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '^' ;
    public final AntlrDatatypeRuleToken ruleBitwiseXOrOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3590:2: (kw= '^' )
            // InternalSolidity.g:3591:2: kw= '^'
            {
            kw=(Token)match(input,52,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3599:1: entryRuleBitwiseOrOperator returns [String current=null] : iv_ruleBitwiseOrOperator= ruleBitwiseOrOperator EOF ;
    public final String entryRuleBitwiseOrOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBitwiseOrOperator = null;


        try {
            // InternalSolidity.g:3599:57: (iv_ruleBitwiseOrOperator= ruleBitwiseOrOperator EOF )
            // InternalSolidity.g:3600:2: iv_ruleBitwiseOrOperator= ruleBitwiseOrOperator EOF
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
    // InternalSolidity.g:3606:1: ruleBitwiseOrOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '|' ;
    public final AntlrDatatypeRuleToken ruleBitwiseOrOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3612:2: (kw= '|' )
            // InternalSolidity.g:3613:2: kw= '|'
            {
            kw=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3621:1: entryRuleBitwiseAndOperator returns [String current=null] : iv_ruleBitwiseAndOperator= ruleBitwiseAndOperator EOF ;
    public final String entryRuleBitwiseAndOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBitwiseAndOperator = null;


        try {
            // InternalSolidity.g:3621:58: (iv_ruleBitwiseAndOperator= ruleBitwiseAndOperator EOF )
            // InternalSolidity.g:3622:2: iv_ruleBitwiseAndOperator= ruleBitwiseAndOperator EOF
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
    // InternalSolidity.g:3628:1: ruleBitwiseAndOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&' ;
    public final AntlrDatatypeRuleToken ruleBitwiseAndOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSolidity.g:3634:2: (kw= '&' )
            // InternalSolidity.g:3635:2: kw= '&'
            {
            kw=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3643:1: entryRuleQID returns [String current=null] : iv_ruleQID= ruleQID EOF ;
    public final String entryRuleQID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQID = null;


        try {
            // InternalSolidity.g:3643:43: (iv_ruleQID= ruleQID EOF )
            // InternalSolidity.g:3644:2: iv_ruleQID= ruleQID EOF
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
    // InternalSolidity.g:3650:1: ruleQID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalSolidity.g:3656:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalSolidity.g:3657:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalSolidity.g:3657:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalSolidity.g:3658:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQIDAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalSolidity.g:3665:3: (kw= '.' this_ID_2= RULE_ID )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==43) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalSolidity.g:3666:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,43,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQIDAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_43); if (state.failed) return current;
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
    // InternalSolidity.g:3683:1: ruleContractType returns [Enumerator current=null] : ( (enumLiteral_0= 'contract' ) | (enumLiteral_1= 'library' ) | (enumLiteral_2= 'interface' ) ) ;
    public final Enumerator ruleContractType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalSolidity.g:3689:2: ( ( (enumLiteral_0= 'contract' ) | (enumLiteral_1= 'library' ) | (enumLiteral_2= 'interface' ) ) )
            // InternalSolidity.g:3690:2: ( (enumLiteral_0= 'contract' ) | (enumLiteral_1= 'library' ) | (enumLiteral_2= 'interface' ) )
            {
            // InternalSolidity.g:3690:2: ( (enumLiteral_0= 'contract' ) | (enumLiteral_1= 'library' ) | (enumLiteral_2= 'interface' ) )
            int alt51=3;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt51=1;
                }
                break;
            case 56:
                {
                alt51=2;
                }
                break;
            case 57:
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
                    // InternalSolidity.g:3691:3: (enumLiteral_0= 'contract' )
                    {
                    // InternalSolidity.g:3691:3: (enumLiteral_0= 'contract' )
                    // InternalSolidity.g:3692:4: enumLiteral_0= 'contract'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getContractTypeAccess().getCONTRACTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getContractTypeAccess().getCONTRACTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3699:3: (enumLiteral_1= 'library' )
                    {
                    // InternalSolidity.g:3699:3: (enumLiteral_1= 'library' )
                    // InternalSolidity.g:3700:4: enumLiteral_1= 'library'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getContractTypeAccess().getLIBRARYEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getContractTypeAccess().getLIBRARYEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3707:3: (enumLiteral_2= 'interface' )
                    {
                    // InternalSolidity.g:3707:3: (enumLiteral_2= 'interface' )
                    // InternalSolidity.g:3708:4: enumLiteral_2= 'interface'
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3718:1: ruleVisibility returns [Enumerator current=null] : ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'internal' ) | (enumLiteral_2= 'private' ) | (enumLiteral_3= 'constant' ) ) ;
    public final Enumerator ruleVisibility() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalSolidity.g:3724:2: ( ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'internal' ) | (enumLiteral_2= 'private' ) | (enumLiteral_3= 'constant' ) ) )
            // InternalSolidity.g:3725:2: ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'internal' ) | (enumLiteral_2= 'private' ) | (enumLiteral_3= 'constant' ) )
            {
            // InternalSolidity.g:3725:2: ( (enumLiteral_0= 'public' ) | (enumLiteral_1= 'internal' ) | (enumLiteral_2= 'private' ) | (enumLiteral_3= 'constant' ) )
            int alt52=4;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt52=1;
                }
                break;
            case 35:
                {
                alt52=2;
                }
                break;
            case 36:
                {
                alt52=3;
                }
                break;
            case 58:
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
                    // InternalSolidity.g:3726:3: (enumLiteral_0= 'public' )
                    {
                    // InternalSolidity.g:3726:3: (enumLiteral_0= 'public' )
                    // InternalSolidity.g:3727:4: enumLiteral_0= 'public'
                    {
                    enumLiteral_0=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getVisibilityAccess().getPUBLICEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3734:3: (enumLiteral_1= 'internal' )
                    {
                    // InternalSolidity.g:3734:3: (enumLiteral_1= 'internal' )
                    // InternalSolidity.g:3735:4: enumLiteral_1= 'internal'
                    {
                    enumLiteral_1=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getVisibilityAccess().getINTERNALEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3742:3: (enumLiteral_2= 'private' )
                    {
                    // InternalSolidity.g:3742:3: (enumLiteral_2= 'private' )
                    // InternalSolidity.g:3743:4: enumLiteral_2= 'private'
                    {
                    enumLiteral_2=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getVisibilityAccess().getPRIVATEEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSolidity.g:3750:3: (enumLiteral_3= 'constant' )
                    {
                    // InternalSolidity.g:3750:3: (enumLiteral_3= 'constant' )
                    // InternalSolidity.g:3751:4: enumLiteral_3= 'constant'
                    {
                    enumLiteral_3=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3761:1: ruleAssignmentOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) ) ;
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
            // InternalSolidity.g:3767:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) ) )
            // InternalSolidity.g:3768:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) )
            {
            // InternalSolidity.g:3768:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '%=' ) | (enumLiteral_4= '+=' ) | (enumLiteral_5= '-=' ) | (enumLiteral_6= '<<=' ) | (enumLiteral_7= '>>=' ) | (enumLiteral_8= '&=' ) | (enumLiteral_9= '^=' ) | (enumLiteral_10= '|=' ) )
            int alt53=11;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt53=1;
                }
                break;
            case 59:
                {
                alt53=2;
                }
                break;
            case 60:
                {
                alt53=3;
                }
                break;
            case 61:
                {
                alt53=4;
                }
                break;
            case 62:
                {
                alt53=5;
                }
                break;
            case 63:
                {
                alt53=6;
                }
                break;
            case 64:
                {
                alt53=7;
                }
                break;
            case 65:
                {
                alt53=8;
                }
                break;
            case 66:
                {
                alt53=9;
                }
                break;
            case 67:
                {
                alt53=10;
                }
                break;
            case 68:
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
                    // InternalSolidity.g:3769:3: (enumLiteral_0= '=' )
                    {
                    // InternalSolidity.g:3769:3: (enumLiteral_0= '=' )
                    // InternalSolidity.g:3770:4: enumLiteral_0= '='
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
                    // InternalSolidity.g:3777:3: (enumLiteral_1= '*=' )
                    {
                    // InternalSolidity.g:3777:3: (enumLiteral_1= '*=' )
                    // InternalSolidity.g:3778:4: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssignmentOperatorAccess().getMultAssignEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3785:3: (enumLiteral_2= '/=' )
                    {
                    // InternalSolidity.g:3785:3: (enumLiteral_2= '/=' )
                    // InternalSolidity.g:3786:4: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssignmentOperatorAccess().getDivAssignEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSolidity.g:3793:3: (enumLiteral_3= '%=' )
                    {
                    // InternalSolidity.g:3793:3: (enumLiteral_3= '%=' )
                    // InternalSolidity.g:3794:4: enumLiteral_3= '%='
                    {
                    enumLiteral_3=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssignmentOperatorAccess().getModAssignEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSolidity.g:3801:3: (enumLiteral_4= '+=' )
                    {
                    // InternalSolidity.g:3801:3: (enumLiteral_4= '+=' )
                    // InternalSolidity.g:3802:4: enumLiteral_4= '+='
                    {
                    enumLiteral_4=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssignmentOperatorAccess().getAddAssignEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalSolidity.g:3809:3: (enumLiteral_5= '-=' )
                    {
                    // InternalSolidity.g:3809:3: (enumLiteral_5= '-=' )
                    // InternalSolidity.g:3810:4: enumLiteral_5= '-='
                    {
                    enumLiteral_5=(Token)match(input,63,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssignmentOperatorAccess().getSubAssignEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalSolidity.g:3817:3: (enumLiteral_6= '<<=' )
                    {
                    // InternalSolidity.g:3817:3: (enumLiteral_6= '<<=' )
                    // InternalSolidity.g:3818:4: enumLiteral_6= '<<='
                    {
                    enumLiteral_6=(Token)match(input,64,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssignmentOperatorAccess().getLeftShiftAssignEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalSolidity.g:3825:3: (enumLiteral_7= '>>=' )
                    {
                    // InternalSolidity.g:3825:3: (enumLiteral_7= '>>=' )
                    // InternalSolidity.g:3826:4: enumLiteral_7= '>>='
                    {
                    enumLiteral_7=(Token)match(input,65,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAssignmentOperatorAccess().getRightShiftAssignEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalSolidity.g:3833:3: (enumLiteral_8= '&=' )
                    {
                    // InternalSolidity.g:3833:3: (enumLiteral_8= '&=' )
                    // InternalSolidity.g:3834:4: enumLiteral_8= '&='
                    {
                    enumLiteral_8=(Token)match(input,66,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getAssignmentOperatorAccess().getAndAssignEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalSolidity.g:3841:3: (enumLiteral_9= '^=' )
                    {
                    // InternalSolidity.g:3841:3: (enumLiteral_9= '^=' )
                    // InternalSolidity.g:3842:4: enumLiteral_9= '^='
                    {
                    enumLiteral_9=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getAssignmentOperatorAccess().getXorAssignEnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalSolidity.g:3849:3: (enumLiteral_10= '|=' )
                    {
                    // InternalSolidity.g:3849:3: (enumLiteral_10= '|=' )
                    // InternalSolidity.g:3850:4: enumLiteral_10= '|='
                    {
                    enumLiteral_10=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3860:1: ruleShiftOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) ;
    public final Enumerator ruleShiftOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalSolidity.g:3866:2: ( ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) ) )
            // InternalSolidity.g:3867:2: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            {
            // InternalSolidity.g:3867:2: ( (enumLiteral_0= '<<' ) | (enumLiteral_1= '>>' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==69) ) {
                alt54=1;
            }
            else if ( (LA54_0==70) ) {
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
                    // InternalSolidity.g:3868:3: (enumLiteral_0= '<<' )
                    {
                    // InternalSolidity.g:3868:3: (enumLiteral_0= '<<' )
                    // InternalSolidity.g:3869:4: enumLiteral_0= '<<'
                    {
                    enumLiteral_0=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getShiftOperatorAccess().getLeftEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3876:3: (enumLiteral_1= '>>' )
                    {
                    // InternalSolidity.g:3876:3: (enumLiteral_1= '>>' )
                    // InternalSolidity.g:3877:4: enumLiteral_1= '>>'
                    {
                    enumLiteral_1=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3887:1: ruleAdditiveOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalSolidity.g:3893:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalSolidity.g:3894:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalSolidity.g:3894:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==71) ) {
                alt55=1;
            }
            else if ( (LA55_0==72) ) {
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
                    // InternalSolidity.g:3895:3: (enumLiteral_0= '+' )
                    {
                    // InternalSolidity.g:3895:3: (enumLiteral_0= '+' )
                    // InternalSolidity.g:3896:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOperatorAccess().getPlusEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3903:3: (enumLiteral_1= '-' )
                    {
                    // InternalSolidity.g:3903:3: (enumLiteral_1= '-' )
                    // InternalSolidity.g:3904:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3914:1: ruleMultiplicativeOperator returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalSolidity.g:3920:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalSolidity.g:3921:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalSolidity.g:3921:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt56=3;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt56=1;
                }
                break;
            case 74:
                {
                alt56=2;
                }
                break;
            case 75:
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
                    // InternalSolidity.g:3922:3: (enumLiteral_0= '*' )
                    {
                    // InternalSolidity.g:3922:3: (enumLiteral_0= '*' )
                    // InternalSolidity.g:3923:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOperatorAccess().getMulEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3930:3: (enumLiteral_1= '/' )
                    {
                    // InternalSolidity.g:3930:3: (enumLiteral_1= '/' )
                    // InternalSolidity.g:3931:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOperatorAccess().getDivEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3938:3: (enumLiteral_2= '%' )
                    {
                    // InternalSolidity.g:3938:3: (enumLiteral_2= '%' )
                    // InternalSolidity.g:3939:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3949:1: ruleUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) ;
    public final Enumerator ruleUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalSolidity.g:3955:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) ) )
            // InternalSolidity.g:3956:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            {
            // InternalSolidity.g:3956:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) )
            int alt57=3;
            switch ( input.LA(1) ) {
            case 71:
                {
                alt57=1;
                }
                break;
            case 72:
                {
                alt57=2;
                }
                break;
            case 76:
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
                    // InternalSolidity.g:3957:3: (enumLiteral_0= '+' )
                    {
                    // InternalSolidity.g:3957:3: (enumLiteral_0= '+' )
                    // InternalSolidity.g:3958:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:3965:3: (enumLiteral_1= '-' )
                    {
                    // InternalSolidity.g:3965:3: (enumLiteral_1= '-' )
                    // InternalSolidity.g:3966:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:3973:3: (enumLiteral_2= '~' )
                    {
                    // InternalSolidity.g:3973:3: (enumLiteral_2= '~' )
                    // InternalSolidity.g:3974:4: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
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
    // InternalSolidity.g:3984:1: ruleRelationalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) ;
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
            // InternalSolidity.g:3990:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) ) )
            // InternalSolidity.g:3991:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            {
            // InternalSolidity.g:3991:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) )
            int alt58=6;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt58=1;
                }
                break;
            case 77:
                {
                alt58=2;
                }
                break;
            case 47:
                {
                alt58=3;
                }
                break;
            case 78:
                {
                alt58=4;
                }
                break;
            case 79:
                {
                alt58=5;
                }
                break;
            case 80:
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
                    // InternalSolidity.g:3992:3: (enumLiteral_0= '<' )
                    {
                    // InternalSolidity.g:3992:3: (enumLiteral_0= '<' )
                    // InternalSolidity.g:3993:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:4000:3: (enumLiteral_1= '<=' )
                    {
                    // InternalSolidity.g:4000:3: (enumLiteral_1= '<=' )
                    // InternalSolidity.g:4001:4: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:4008:3: (enumLiteral_2= '>' )
                    {
                    // InternalSolidity.g:4008:3: (enumLiteral_2= '>' )
                    // InternalSolidity.g:4009:4: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSolidity.g:4016:3: (enumLiteral_3= '>=' )
                    {
                    // InternalSolidity.g:4016:3: (enumLiteral_3= '>=' )
                    // InternalSolidity.g:4017:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSolidity.g:4024:3: (enumLiteral_4= '==' )
                    {
                    // InternalSolidity.g:4024:3: (enumLiteral_4= '==' )
                    // InternalSolidity.g:4025:4: enumLiteral_4= '=='
                    {
                    enumLiteral_4=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalSolidity.g:4032:3: (enumLiteral_5= '!=' )
                    {
                    // InternalSolidity.g:4032:3: (enumLiteral_5= '!=' )
                    // InternalSolidity.g:4033:4: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
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
        // InternalSolidity.g:2067:4: ( ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) ) )
        // InternalSolidity.g:2067:5: ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) )
        {
        // InternalSolidity.g:2067:5: ( () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) ) )
        // InternalSolidity.g:2068:5: () ( ( ruleAdditiveOperator ) ) ( ( ruleNumericalMultiplyDivideExpression ) )
        {
        // InternalSolidity.g:2068:5: ()
        // InternalSolidity.g:2069:5: 
        {
        }

        // InternalSolidity.g:2070:5: ( ( ruleAdditiveOperator ) )
        // InternalSolidity.g:2071:6: ( ruleAdditiveOperator )
        {
        // InternalSolidity.g:2071:6: ( ruleAdditiveOperator )
        // InternalSolidity.g:2072:7: ruleAdditiveOperator
        {
        pushFollow(FOLLOW_33);
        ruleAdditiveOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalSolidity.g:2075:5: ( ( ruleNumericalMultiplyDivideExpression ) )
        // InternalSolidity.g:2076:6: ( ruleNumericalMultiplyDivideExpression )
        {
        // InternalSolidity.g:2076:6: ( ruleNumericalMultiplyDivideExpression )
        // InternalSolidity.g:2077:7: ruleNumericalMultiplyDivideExpression
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
        // InternalSolidity.g:2158:4: ( ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) ) )
        // InternalSolidity.g:2158:5: ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) )
        {
        // InternalSolidity.g:2158:5: ( () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) ) )
        // InternalSolidity.g:2159:5: () ( ( ruleMultiplicativeOperator ) ) ( ( ruleNumericalUnaryExpression ) )
        {
        // InternalSolidity.g:2159:5: ()
        // InternalSolidity.g:2160:5: 
        {
        }

        // InternalSolidity.g:2161:5: ( ( ruleMultiplicativeOperator ) )
        // InternalSolidity.g:2162:6: ( ruleMultiplicativeOperator )
        {
        // InternalSolidity.g:2162:6: ( ruleMultiplicativeOperator )
        // InternalSolidity.g:2163:7: ruleMultiplicativeOperator
        {
        pushFollow(FOLLOW_33);
        ruleMultiplicativeOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalSolidity.g:2166:5: ( ( ruleNumericalUnaryExpression ) )
        // InternalSolidity.g:2167:6: ( ruleNumericalUnaryExpression )
        {
        // InternalSolidity.g:2167:6: ( ruleNumericalUnaryExpression )
        // InternalSolidity.g:2168:7: ruleNumericalUnaryExpression
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
        // InternalSolidity.g:2499:7: ( ( '(' ) )
        // InternalSolidity.g:2499:8: ( '(' )
        {
        // InternalSolidity.g:2499:8: ( '(' )
        // InternalSolidity.g:2500:8: '('
        {
        match(input,29,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalSolidity

    // $ANTLR start synpred4_InternalSolidity
    public final void synpred4_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2570:7: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )
        // InternalSolidity.g:2570:8: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        {
        // InternalSolidity.g:2570:8: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        // InternalSolidity.g:2571:8: ( ( '[' ) ) ( ( ruleExpression ) ) ']'
        {
        // InternalSolidity.g:2571:8: ( ( '[' ) )
        // InternalSolidity.g:2572:9: ( '[' )
        {
        // InternalSolidity.g:2572:9: ( '[' )
        // InternalSolidity.g:2573:10: '['
        {
        match(input,44,FOLLOW_15); if (state.failed) return ;

        }


        }

        // InternalSolidity.g:2576:8: ( ( ruleExpression ) )
        // InternalSolidity.g:2577:9: ( ruleExpression )
        {
        // InternalSolidity.g:2577:9: ( ruleExpression )
        // InternalSolidity.g:2578:10: ruleExpression
        {
        pushFollow(FOLLOW_46);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,45,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalSolidity

    // $ANTLR start synpred5_InternalSolidity
    public final void synpred5_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2625:7: ( ( '[' ( ( ruleExpression ) ) ']' ) )
        // InternalSolidity.g:2625:8: ( '[' ( ( ruleExpression ) ) ']' )
        {
        // InternalSolidity.g:2625:8: ( '[' ( ( ruleExpression ) ) ']' )
        // InternalSolidity.g:2626:8: '[' ( ( ruleExpression ) ) ']'
        {
        match(input,44,FOLLOW_15); if (state.failed) return ;
        // InternalSolidity.g:2627:8: ( ( ruleExpression ) )
        // InternalSolidity.g:2628:9: ( ruleExpression )
        {
        // InternalSolidity.g:2628:9: ( ruleExpression )
        // InternalSolidity.g:2629:10: ruleExpression
        {
        pushFollow(FOLLOW_46);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,45,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalSolidity

    // $ANTLR start synpred6_InternalSolidity
    public final void synpred6_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2710:6: ( ( '(' ) )
        // InternalSolidity.g:2710:7: ( '(' )
        {
        // InternalSolidity.g:2710:7: ( '(' )
        // InternalSolidity.g:2711:7: '('
        {
        match(input,29,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalSolidity

    // $ANTLR start synpred7_InternalSolidity
    public final void synpred7_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2781:6: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )
        // InternalSolidity.g:2781:7: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        {
        // InternalSolidity.g:2781:7: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        // InternalSolidity.g:2782:7: ( ( '[' ) ) ( ( ruleExpression ) ) ']'
        {
        // InternalSolidity.g:2782:7: ( ( '[' ) )
        // InternalSolidity.g:2783:8: ( '[' )
        {
        // InternalSolidity.g:2783:8: ( '[' )
        // InternalSolidity.g:2784:9: '['
        {
        match(input,44,FOLLOW_15); if (state.failed) return ;

        }


        }

        // InternalSolidity.g:2787:7: ( ( ruleExpression ) )
        // InternalSolidity.g:2788:8: ( ruleExpression )
        {
        // InternalSolidity.g:2788:8: ( ruleExpression )
        // InternalSolidity.g:2789:9: ruleExpression
        {
        pushFollow(FOLLOW_46);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,45,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalSolidity

    // $ANTLR start synpred8_InternalSolidity
    public final void synpred8_InternalSolidity_fragment() throws RecognitionException {   
        // InternalSolidity.g:2836:6: ( ( '[' ( ( ruleExpression ) ) ']' ) )
        // InternalSolidity.g:2836:7: ( '[' ( ( ruleExpression ) ) ']' )
        {
        // InternalSolidity.g:2836:7: ( '[' ( ( ruleExpression ) ) ']' )
        // InternalSolidity.g:2837:7: '[' ( ( ruleExpression ) ) ']'
        {
        match(input,44,FOLLOW_15); if (state.failed) return ;
        // InternalSolidity.g:2838:7: ( ( ruleExpression ) )
        // InternalSolidity.g:2839:8: ( ruleExpression )
        {
        // InternalSolidity.g:2839:8: ( ruleExpression )
        // InternalSolidity.g:2840:9: ruleExpression
        {
        pushFollow(FOLLOW_46);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,45,FOLLOW_2); if (state.failed) return ;

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0380000000120002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000003011A000040L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0400001C00000040L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x00090000A0001FE0L,0x0000000000001180L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000002000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000040800040L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000040800000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x00090000A2001FE0L,0x0000000000001180L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000020000040L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000003E01080000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000001080000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000002800020L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000002800000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0xF800000004000002L,0x000000000000001FL});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00010000A0001FE0L,0x0000000000001180L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000C00000000002L,0x000000000001E000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000E00L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00010000A0001FE0L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000180020000002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x00090000E0001FE0L,0x0000000000001180L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000100020000002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000800000800000L});

}