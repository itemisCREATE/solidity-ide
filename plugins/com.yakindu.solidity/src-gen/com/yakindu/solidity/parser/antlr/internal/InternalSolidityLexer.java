package com.yakindu.solidity.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSolidityLexer extends Lexer {
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

    public InternalSolidityLexer() {;} 
    public InternalSolidityLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalSolidityLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalSolidity.g"; }

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:11:7: ( 'pragma' )
            // InternalSolidity.g:11:9: 'pragma'
            {
            match("pragma"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:12:7: ( 'solidity' )
            // InternalSolidity.g:12:9: 'solidity'
            {
            match("solidity"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:13:7: ( ';' )
            // InternalSolidity.g:13:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:14:7: ( 'import' )
            // InternalSolidity.g:14:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:15:7: ( 'as' )
            // InternalSolidity.g:15:9: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:16:7: ( 'is' )
            // InternalSolidity.g:16:9: 'is'
            {
            match("is"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:17:7: ( ',' )
            // InternalSolidity.g:17:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:18:7: ( '{' )
            // InternalSolidity.g:18:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:19:7: ( '}' )
            // InternalSolidity.g:19:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:20:7: ( '=' )
            // InternalSolidity.g:20:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:21:7: ( 'struct' )
            // InternalSolidity.g:21:9: 'struct'
            {
            match("struct"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:22:7: ( 'modifier' )
            // InternalSolidity.g:22:9: 'modifier'
            {
            match("modifier"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:23:7: ( '(' )
            // InternalSolidity.g:23:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:24:7: ( ')' )
            // InternalSolidity.g:24:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:25:7: ( '_;' )
            // InternalSolidity.g:25:9: '_;'
            {
            match("_;"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:26:7: ( 'function' )
            // InternalSolidity.g:26:9: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:27:7: ( 'external' )
            // InternalSolidity.g:27:9: 'external'
            {
            match("external"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:28:7: ( 'public' )
            // InternalSolidity.g:28:9: 'public'
            {
            match("public"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:29:7: ( 'internal' )
            // InternalSolidity.g:29:9: 'internal'
            {
            match("internal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:30:7: ( 'private' )
            // InternalSolidity.g:30:9: 'private'
            {
            match("private"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:31:7: ( 'returns' )
            // InternalSolidity.g:31:9: 'returns'
            {
            match("returns"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:32:7: ( '...' )
            // InternalSolidity.g:32:9: '...'
            {
            match("..."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:33:7: ( ':' )
            // InternalSolidity.g:33:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:34:7: ( 'event' )
            // InternalSolidity.g:34:9: 'event'
            {
            match("event"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:35:7: ( 'enum' )
            // InternalSolidity.g:35:9: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:36:7: ( '?' )
            // InternalSolidity.g:36:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:37:7: ( '.' )
            // InternalSolidity.g:37:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:38:7: ( '[' )
            // InternalSolidity.g:38:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:39:7: ( ']' )
            // InternalSolidity.g:39:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:40:7: ( '<' )
            // InternalSolidity.g:40:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:41:7: ( '>' )
            // InternalSolidity.g:41:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:42:7: ( 'null' )
            // InternalSolidity.g:42:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:43:7: ( '&&' )
            // InternalSolidity.g:43:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:44:7: ( '||' )
            // InternalSolidity.g:44:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:45:7: ( '!' )
            // InternalSolidity.g:45:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:46:7: ( '^' )
            // InternalSolidity.g:46:9: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:47:7: ( '|' )
            // InternalSolidity.g:47:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:48:7: ( '&' )
            // InternalSolidity.g:48:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:49:7: ( 'contract' )
            // InternalSolidity.g:49:9: 'contract'
            {
            match("contract"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:50:7: ( 'library' )
            // InternalSolidity.g:50:9: 'library'
            {
            match("library"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:51:7: ( 'interface' )
            // InternalSolidity.g:51:9: 'interface'
            {
            match("interface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:52:7: ( 'constant' )
            // InternalSolidity.g:52:9: 'constant'
            {
            match("constant"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:53:7: ( '*=' )
            // InternalSolidity.g:53:9: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:54:7: ( '/=' )
            // InternalSolidity.g:54:9: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:55:7: ( '%=' )
            // InternalSolidity.g:55:9: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:56:7: ( '+=' )
            // InternalSolidity.g:56:9: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:57:7: ( '-=' )
            // InternalSolidity.g:57:9: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:58:7: ( '<<=' )
            // InternalSolidity.g:58:9: '<<='
            {
            match("<<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:59:7: ( '>>=' )
            // InternalSolidity.g:59:9: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:60:7: ( '&=' )
            // InternalSolidity.g:60:9: '&='
            {
            match("&="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:61:7: ( '^=' )
            // InternalSolidity.g:61:9: '^='
            {
            match("^="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:62:7: ( '|=' )
            // InternalSolidity.g:62:9: '|='
            {
            match("|="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:63:7: ( '<<' )
            // InternalSolidity.g:63:9: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:64:7: ( '>>' )
            // InternalSolidity.g:64:9: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:65:7: ( '+' )
            // InternalSolidity.g:65:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:66:7: ( '-' )
            // InternalSolidity.g:66:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:67:7: ( '*' )
            // InternalSolidity.g:67:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:68:7: ( '/' )
            // InternalSolidity.g:68:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:69:7: ( '%' )
            // InternalSolidity.g:69:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:70:7: ( '~' )
            // InternalSolidity.g:70:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:71:7: ( '<=' )
            // InternalSolidity.g:71:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:72:7: ( '>=' )
            // InternalSolidity.g:72:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:73:7: ( '==' )
            // InternalSolidity.g:73:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:74:7: ( '!=' )
            // InternalSolidity.g:74:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "RULE_VERSION"
    public final void mRULE_VERSION() throws RecognitionException {
        try {
            int _type = RULE_VERSION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4042:14: ( '^' RULE_INT . RULE_INT . RULE_INT )
            // InternalSolidity.g:4042:16: '^' RULE_INT . RULE_INT . RULE_INT
            {
            match('^'); 
            mRULE_INT(); 
            matchAny(); 
            mRULE_INT(); 
            matchAny(); 
            mRULE_INT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_VERSION"

    // $ANTLR start "RULE_BOOL"
    public final void mRULE_BOOL() throws RecognitionException {
        try {
            int _type = RULE_BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4044:11: ( ( 'true' | 'false' | 'yes' | 'no' ) )
            // InternalSolidity.g:4044:13: ( 'true' | 'false' | 'yes' | 'no' )
            {
            // InternalSolidity.g:4044:13: ( 'true' | 'false' | 'yes' | 'no' )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt1=1;
                }
                break;
            case 'f':
                {
                alt1=2;
                }
                break;
            case 'y':
                {
                alt1=3;
                }
                break;
            case 'n':
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalSolidity.g:4044:14: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalSolidity.g:4044:21: 'false'
                    {
                    match("false"); 


                    }
                    break;
                case 3 :
                    // InternalSolidity.g:4044:29: 'yes'
                    {
                    match("yes"); 


                    }
                    break;
                case 4 :
                    // InternalSolidity.g:4044:35: 'no'
                    {
                    match("no"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOL"

    // $ANTLR start "RULE_HEX"
    public final void mRULE_HEX() throws RecognitionException {
        try {
            int _type = RULE_HEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4046:10: ( '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+ )
            // InternalSolidity.g:4046:12: '0' ( 'x' | 'X' ) ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            {
            match('0'); 
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalSolidity.g:4046:26: ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='F')||(LA2_0>='a' && LA2_0<='f')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSolidity.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEX"

    // $ANTLR start "RULE_BINARY"
    public final void mRULE_BINARY() throws RecognitionException {
        try {
            int _type = RULE_BINARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4048:13: ( '0' ( 'b' | 'B' ) ( '0' | '1' )+ )
            // InternalSolidity.g:4048:15: '0' ( 'b' | 'B' ) ( '0' | '1' )+
            {
            match('0'); 
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalSolidity.g:4048:29: ( '0' | '1' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='1')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalSolidity.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='1') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BINARY"

    // $ANTLR start "RULE_DOUBLE"
    public final void mRULE_DOUBLE() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4050:13: ( RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? ( 'd' | 'D' )? )
            // InternalSolidity.g:4050:15: RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? ( 'd' | 'D' )?
            {
            mRULE_INT(); 
            match('.'); 
            mRULE_INT(); 
            // InternalSolidity.g:4050:37: ( 'e' ( '-' | '+' ) RULE_INT )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='e') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalSolidity.g:4050:38: 'e' ( '-' | '+' ) RULE_INT
                    {
                    match('e'); 
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    mRULE_INT(); 

                    }
                    break;

            }

            // InternalSolidity.g:4050:63: ( 'd' | 'D' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='D'||LA5_0=='d') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSolidity.g:
                    {
                    if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4052:12: ( RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? ( 'f' | 'F' )? )
            // InternalSolidity.g:4052:14: RULE_INT '.' RULE_INT ( 'e' ( '-' | '+' ) RULE_INT )? ( 'f' | 'F' )?
            {
            mRULE_INT(); 
            match('.'); 
            mRULE_INT(); 
            // InternalSolidity.g:4052:36: ( 'e' ( '-' | '+' ) RULE_INT )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='e') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalSolidity.g:4052:37: 'e' ( '-' | '+' ) RULE_INT
                    {
                    match('e'); 
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    mRULE_INT(); 

                    }
                    break;

            }

            // InternalSolidity.g:4052:62: ( 'f' | 'F' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='F'||LA7_0=='f') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalSolidity.g:
                    {
                    if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4054:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalSolidity.g:4054:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalSolidity.g:4054:11: ( '^' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='^') ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalSolidity.g:4054:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalSolidity.g:4054:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalSolidity.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4056:10: ( ( '0' .. '9' )+ )
            // InternalSolidity.g:4056:12: ( '0' .. '9' )+
            {
            // InternalSolidity.g:4056:12: ( '0' .. '9' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSolidity.g:4056:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4058:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalSolidity.g:4058:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalSolidity.g:4058:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\"') ) {
                alt13=1;
            }
            else if ( (LA13_0=='\'') ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalSolidity.g:4058:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalSolidity.g:4058:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop11:
                    do {
                        int alt11=3;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0=='\\') ) {
                            alt11=1;
                        }
                        else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFF')) ) {
                            alt11=2;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalSolidity.g:4058:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalSolidity.g:4058:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalSolidity.g:4058:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalSolidity.g:4058:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\\') ) {
                            alt12=1;
                        }
                        else if ( ((LA12_0>='\u0000' && LA12_0<='&')||(LA12_0>='(' && LA12_0<='[')||(LA12_0>=']' && LA12_0<='\uFFFF')) ) {
                            alt12=2;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalSolidity.g:4058:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalSolidity.g:4058:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4060:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalSolidity.g:4060:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalSolidity.g:4060:24: ( options {greedy=false; } : . )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='*') ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1=='/') ) {
                        alt14=2;
                    }
                    else if ( ((LA14_1>='\u0000' && LA14_1<='.')||(LA14_1>='0' && LA14_1<='\uFFFF')) ) {
                        alt14=1;
                    }


                }
                else if ( ((LA14_0>='\u0000' && LA14_0<=')')||(LA14_0>='+' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalSolidity.g:4060:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4062:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalSolidity.g:4062:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalSolidity.g:4062:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>='\u0000' && LA15_0<='\t')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSolidity.g:4062:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // InternalSolidity.g:4062:40: ( ( '\\r' )? '\\n' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\n'||LA17_0=='\r') ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalSolidity.g:4062:41: ( '\\r' )? '\\n'
                    {
                    // InternalSolidity.g:4062:41: ( '\\r' )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0=='\r') ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalSolidity.g:4062:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4064:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalSolidity.g:4064:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalSolidity.g:4064:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>='\t' && LA18_0<='\n')||LA18_0=='\r'||LA18_0==' ') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSolidity.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSolidity.g:4066:16: ( . )
            // InternalSolidity.g:4066:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalSolidity.g:1:8: ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | RULE_VERSION | RULE_BOOL | RULE_HEX | RULE_BINARY | RULE_DOUBLE | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt19=77;
        alt19 = dfa19.predict(input);
        switch (alt19) {
            case 1 :
                // InternalSolidity.g:1:10: T__17
                {
                mT__17(); 

                }
                break;
            case 2 :
                // InternalSolidity.g:1:16: T__18
                {
                mT__18(); 

                }
                break;
            case 3 :
                // InternalSolidity.g:1:22: T__19
                {
                mT__19(); 

                }
                break;
            case 4 :
                // InternalSolidity.g:1:28: T__20
                {
                mT__20(); 

                }
                break;
            case 5 :
                // InternalSolidity.g:1:34: T__21
                {
                mT__21(); 

                }
                break;
            case 6 :
                // InternalSolidity.g:1:40: T__22
                {
                mT__22(); 

                }
                break;
            case 7 :
                // InternalSolidity.g:1:46: T__23
                {
                mT__23(); 

                }
                break;
            case 8 :
                // InternalSolidity.g:1:52: T__24
                {
                mT__24(); 

                }
                break;
            case 9 :
                // InternalSolidity.g:1:58: T__25
                {
                mT__25(); 

                }
                break;
            case 10 :
                // InternalSolidity.g:1:64: T__26
                {
                mT__26(); 

                }
                break;
            case 11 :
                // InternalSolidity.g:1:70: T__27
                {
                mT__27(); 

                }
                break;
            case 12 :
                // InternalSolidity.g:1:76: T__28
                {
                mT__28(); 

                }
                break;
            case 13 :
                // InternalSolidity.g:1:82: T__29
                {
                mT__29(); 

                }
                break;
            case 14 :
                // InternalSolidity.g:1:88: T__30
                {
                mT__30(); 

                }
                break;
            case 15 :
                // InternalSolidity.g:1:94: T__31
                {
                mT__31(); 

                }
                break;
            case 16 :
                // InternalSolidity.g:1:100: T__32
                {
                mT__32(); 

                }
                break;
            case 17 :
                // InternalSolidity.g:1:106: T__33
                {
                mT__33(); 

                }
                break;
            case 18 :
                // InternalSolidity.g:1:112: T__34
                {
                mT__34(); 

                }
                break;
            case 19 :
                // InternalSolidity.g:1:118: T__35
                {
                mT__35(); 

                }
                break;
            case 20 :
                // InternalSolidity.g:1:124: T__36
                {
                mT__36(); 

                }
                break;
            case 21 :
                // InternalSolidity.g:1:130: T__37
                {
                mT__37(); 

                }
                break;
            case 22 :
                // InternalSolidity.g:1:136: T__38
                {
                mT__38(); 

                }
                break;
            case 23 :
                // InternalSolidity.g:1:142: T__39
                {
                mT__39(); 

                }
                break;
            case 24 :
                // InternalSolidity.g:1:148: T__40
                {
                mT__40(); 

                }
                break;
            case 25 :
                // InternalSolidity.g:1:154: T__41
                {
                mT__41(); 

                }
                break;
            case 26 :
                // InternalSolidity.g:1:160: T__42
                {
                mT__42(); 

                }
                break;
            case 27 :
                // InternalSolidity.g:1:166: T__43
                {
                mT__43(); 

                }
                break;
            case 28 :
                // InternalSolidity.g:1:172: T__44
                {
                mT__44(); 

                }
                break;
            case 29 :
                // InternalSolidity.g:1:178: T__45
                {
                mT__45(); 

                }
                break;
            case 30 :
                // InternalSolidity.g:1:184: T__46
                {
                mT__46(); 

                }
                break;
            case 31 :
                // InternalSolidity.g:1:190: T__47
                {
                mT__47(); 

                }
                break;
            case 32 :
                // InternalSolidity.g:1:196: T__48
                {
                mT__48(); 

                }
                break;
            case 33 :
                // InternalSolidity.g:1:202: T__49
                {
                mT__49(); 

                }
                break;
            case 34 :
                // InternalSolidity.g:1:208: T__50
                {
                mT__50(); 

                }
                break;
            case 35 :
                // InternalSolidity.g:1:214: T__51
                {
                mT__51(); 

                }
                break;
            case 36 :
                // InternalSolidity.g:1:220: T__52
                {
                mT__52(); 

                }
                break;
            case 37 :
                // InternalSolidity.g:1:226: T__53
                {
                mT__53(); 

                }
                break;
            case 38 :
                // InternalSolidity.g:1:232: T__54
                {
                mT__54(); 

                }
                break;
            case 39 :
                // InternalSolidity.g:1:238: T__55
                {
                mT__55(); 

                }
                break;
            case 40 :
                // InternalSolidity.g:1:244: T__56
                {
                mT__56(); 

                }
                break;
            case 41 :
                // InternalSolidity.g:1:250: T__57
                {
                mT__57(); 

                }
                break;
            case 42 :
                // InternalSolidity.g:1:256: T__58
                {
                mT__58(); 

                }
                break;
            case 43 :
                // InternalSolidity.g:1:262: T__59
                {
                mT__59(); 

                }
                break;
            case 44 :
                // InternalSolidity.g:1:268: T__60
                {
                mT__60(); 

                }
                break;
            case 45 :
                // InternalSolidity.g:1:274: T__61
                {
                mT__61(); 

                }
                break;
            case 46 :
                // InternalSolidity.g:1:280: T__62
                {
                mT__62(); 

                }
                break;
            case 47 :
                // InternalSolidity.g:1:286: T__63
                {
                mT__63(); 

                }
                break;
            case 48 :
                // InternalSolidity.g:1:292: T__64
                {
                mT__64(); 

                }
                break;
            case 49 :
                // InternalSolidity.g:1:298: T__65
                {
                mT__65(); 

                }
                break;
            case 50 :
                // InternalSolidity.g:1:304: T__66
                {
                mT__66(); 

                }
                break;
            case 51 :
                // InternalSolidity.g:1:310: T__67
                {
                mT__67(); 

                }
                break;
            case 52 :
                // InternalSolidity.g:1:316: T__68
                {
                mT__68(); 

                }
                break;
            case 53 :
                // InternalSolidity.g:1:322: T__69
                {
                mT__69(); 

                }
                break;
            case 54 :
                // InternalSolidity.g:1:328: T__70
                {
                mT__70(); 

                }
                break;
            case 55 :
                // InternalSolidity.g:1:334: T__71
                {
                mT__71(); 

                }
                break;
            case 56 :
                // InternalSolidity.g:1:340: T__72
                {
                mT__72(); 

                }
                break;
            case 57 :
                // InternalSolidity.g:1:346: T__73
                {
                mT__73(); 

                }
                break;
            case 58 :
                // InternalSolidity.g:1:352: T__74
                {
                mT__74(); 

                }
                break;
            case 59 :
                // InternalSolidity.g:1:358: T__75
                {
                mT__75(); 

                }
                break;
            case 60 :
                // InternalSolidity.g:1:364: T__76
                {
                mT__76(); 

                }
                break;
            case 61 :
                // InternalSolidity.g:1:370: T__77
                {
                mT__77(); 

                }
                break;
            case 62 :
                // InternalSolidity.g:1:376: T__78
                {
                mT__78(); 

                }
                break;
            case 63 :
                // InternalSolidity.g:1:382: T__79
                {
                mT__79(); 

                }
                break;
            case 64 :
                // InternalSolidity.g:1:388: T__80
                {
                mT__80(); 

                }
                break;
            case 65 :
                // InternalSolidity.g:1:394: RULE_VERSION
                {
                mRULE_VERSION(); 

                }
                break;
            case 66 :
                // InternalSolidity.g:1:407: RULE_BOOL
                {
                mRULE_BOOL(); 

                }
                break;
            case 67 :
                // InternalSolidity.g:1:417: RULE_HEX
                {
                mRULE_HEX(); 

                }
                break;
            case 68 :
                // InternalSolidity.g:1:426: RULE_BINARY
                {
                mRULE_BINARY(); 

                }
                break;
            case 69 :
                // InternalSolidity.g:1:438: RULE_DOUBLE
                {
                mRULE_DOUBLE(); 

                }
                break;
            case 70 :
                // InternalSolidity.g:1:450: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 71 :
                // InternalSolidity.g:1:461: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 72 :
                // InternalSolidity.g:1:469: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 73 :
                // InternalSolidity.g:1:478: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 74 :
                // InternalSolidity.g:1:490: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 75 :
                // InternalSolidity.g:1:506: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 76 :
                // InternalSolidity.g:1:522: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 77 :
                // InternalSolidity.g:1:530: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA19_eotS =
        "\1\uffff\2\60\1\uffff\2\60\3\uffff\1\74\1\60\2\uffff\4\60\1\110\4\uffff\1\117\1\122\1\60\1\127\1\132\1\134\1\136\2\60\1\143\1\147\1\151\1\153\1\155\1\uffff\2\60\2\163\1\uffff\2\55\2\uffff\2\60\1\uffff\2\60\1\uffff\1\60\1\176\1\60\1\u0080\5\uffff\1\60\3\uffff\6\60\6\uffff\1\u0089\2\uffff\1\u008b\2\uffff\1\60\1\u008d\13\uffff\2\60\15\uffff\2\60\4\uffff\1\163\2\uffff\6\60\1\uffff\1\60\1\uffff\7\60\4\uffff\1\60\1\uffff\3\60\1\u008d\1\u00a6\14\60\1\u00b5\1\60\1\u00b7\3\60\1\u008d\3\uffff\11\60\1\u008d\1\60\1\u00c7\1\uffff\1\60\1\uffff\3\60\1\uffff\1\u00cd\1\60\1\u00cf\1\60\1\u00d1\1\u00d2\5\60\1\uffff\4\60\1\u00a6\1\uffff\1\u00dc\1\uffff\1\60\2\uffff\5\60\1\u00e3\2\60\1\u00e6\1\uffff\1\u00e7\1\u00e8\1\60\1\u00ea\1\u00eb\1\u00ec\1\uffff\1\u00ed\1\u00ee\3\uffff\1\u00ef\6\uffff";
    static final String DFA19_eofS =
        "\u00f0\uffff";
    static final String DFA19_minS =
        "\1\0\1\162\1\157\1\uffff\1\155\1\163\3\uffff\1\75\1\157\2\uffff\1\73\1\141\1\156\1\145\1\56\4\uffff\1\74\1\75\1\157\1\46\2\75\1\60\1\157\1\151\1\75\1\52\3\75\1\uffff\1\162\1\145\2\56\1\uffff\2\0\2\uffff\1\141\1\142\1\uffff\1\154\1\162\1\uffff\1\160\1\60\1\164\1\60\5\uffff\1\144\3\uffff\1\156\1\154\1\164\1\145\1\165\1\164\6\uffff\1\75\2\uffff\1\75\2\uffff\1\154\1\60\13\uffff\1\156\1\142\15\uffff\1\165\1\163\3\uffff\1\60\1\56\2\uffff\1\147\1\166\1\154\1\151\1\165\1\157\1\uffff\1\145\1\uffff\1\151\1\143\1\163\1\145\1\156\1\155\1\165\4\uffff\1\154\1\uffff\1\163\1\162\1\145\2\60\1\155\1\141\1\151\1\144\1\143\2\162\1\146\1\164\1\145\1\162\1\164\1\60\1\162\1\60\1\162\1\164\1\141\1\60\1\uffff\1\53\1\uffff\1\141\1\164\1\143\1\151\2\164\1\146\2\151\1\60\1\156\1\60\1\uffff\1\156\1\uffff\2\141\1\162\2\60\1\145\1\60\1\164\2\60\2\141\1\145\1\157\1\141\1\uffff\1\163\1\143\1\156\1\171\1\60\1\uffff\1\60\1\uffff\1\171\2\uffff\1\154\1\143\1\162\1\156\1\154\1\60\2\164\1\60\1\uffff\2\60\1\145\3\60\1\uffff\2\60\3\uffff\1\60\6\uffff";
    static final String DFA19_maxS =
        "\1\uffff\1\165\1\164\1\uffff\2\163\3\uffff\1\75\1\157\2\uffff\1\73\1\165\1\170\1\145\1\56\4\uffff\1\75\1\76\1\165\1\75\1\174\1\75\1\172\1\157\1\151\5\75\1\uffff\1\162\1\145\1\170\1\71\1\uffff\2\uffff\2\uffff\1\151\1\142\1\uffff\1\154\1\162\1\uffff\1\160\1\172\1\164\1\172\5\uffff\1\144\3\uffff\1\156\1\154\1\164\1\145\1\165\1\164\6\uffff\1\75\2\uffff\1\75\2\uffff\1\154\1\172\13\uffff\1\156\1\142\15\uffff\1\165\1\163\3\uffff\2\71\2\uffff\1\147\1\166\1\154\1\151\1\165\1\157\1\uffff\1\145\1\uffff\1\151\1\143\1\163\1\145\1\156\1\155\1\165\4\uffff\1\154\1\uffff\1\164\1\162\1\145\1\172\1\146\1\155\1\141\1\151\1\144\1\143\2\162\1\146\1\164\1\145\1\162\1\164\1\172\1\162\1\172\1\162\1\164\1\141\1\172\1\uffff\1\55\1\uffff\1\141\1\164\1\143\1\151\2\164\1\156\2\151\1\172\1\156\1\172\1\uffff\1\156\1\uffff\2\141\1\162\1\71\1\172\1\145\1\172\1\164\2\172\2\141\1\145\1\157\1\141\1\uffff\1\163\1\143\1\156\1\171\1\146\1\uffff\1\172\1\uffff\1\171\2\uffff\1\154\1\143\1\162\1\156\1\154\1\172\2\164\1\172\1\uffff\2\172\1\145\3\172\1\uffff\2\172\3\uffff\1\172\6\uffff";
    static final String DFA19_acceptS =
        "\3\uffff\1\3\2\uffff\1\7\1\10\1\11\2\uffff\1\15\1\16\5\uffff\1\27\1\32\1\34\1\35\16\uffff\1\74\4\uffff\1\107\2\uffff\1\114\1\115\2\uffff\1\107\2\uffff\1\3\4\uffff\1\7\1\10\1\11\1\77\1\12\1\uffff\1\15\1\16\1\17\6\uffff\1\26\1\33\1\27\1\32\1\34\1\35\1\uffff\1\75\1\36\1\uffff\1\76\1\37\2\uffff\1\41\1\62\1\46\1\42\1\64\1\45\1\100\1\43\1\63\1\44\1\101\2\uffff\1\53\1\71\1\54\1\112\1\113\1\72\1\55\1\73\1\56\1\67\1\57\1\70\1\74\2\uffff\1\103\1\104\1\110\2\uffff\1\111\1\114\6\uffff\1\6\1\uffff\1\5\7\uffff\1\60\1\65\1\61\1\66\1\uffff\1\102\30\uffff\1\105\1\uffff\1\106\14\uffff\1\31\1\uffff\1\40\17\uffff\1\30\5\uffff\1\1\1\uffff\1\22\1\uffff\1\13\1\4\11\uffff\1\24\6\uffff\1\25\2\uffff\1\50\1\2\1\23\1\uffff\1\14\1\20\1\21\1\47\1\52\1\51";
    static final String DFA19_specialS =
        "\1\0\51\uffff\1\1\1\2\u00c4\uffff}>";
    static final String[] DFA19_transitionS = {
            "\11\55\2\54\2\55\1\54\22\55\1\54\1\33\1\52\2\55\1\41\1\31\1\53\1\13\1\14\1\37\1\42\1\6\1\43\1\21\1\40\1\47\11\50\1\22\1\3\1\26\1\11\1\27\1\23\1\55\32\51\1\24\1\55\1\25\1\34\1\15\1\55\1\5\1\51\1\35\1\51\1\17\1\16\2\51\1\4\2\51\1\36\1\12\1\30\1\51\1\1\1\51\1\20\1\2\1\45\4\51\1\46\1\51\1\7\1\32\1\10\1\44\uff81\55",
            "\1\56\2\uffff\1\57",
            "\1\61\4\uffff\1\62",
            "",
            "\1\64\1\66\4\uffff\1\65",
            "\1\67",
            "",
            "",
            "",
            "\1\73",
            "\1\75",
            "",
            "",
            "\1\100",
            "\1\102\23\uffff\1\101",
            "\1\105\7\uffff\1\104\1\uffff\1\103",
            "\1\106",
            "\1\107",
            "",
            "",
            "",
            "",
            "\1\115\1\116",
            "\1\121\1\120",
            "\1\124\5\uffff\1\123",
            "\1\125\26\uffff\1\126",
            "\1\131\76\uffff\1\130",
            "\1\133",
            "\12\137\3\uffff\1\135\3\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\145\4\uffff\1\146\15\uffff\1\144",
            "\1\150",
            "\1\152",
            "\1\154",
            "",
            "\1\157",
            "\1\160",
            "\1\164\1\uffff\12\165\10\uffff\1\162\25\uffff\1\161\11\uffff\1\162\25\uffff\1\161",
            "\1\164\1\uffff\12\165",
            "",
            "\0\166",
            "\0\166",
            "",
            "",
            "\1\170\7\uffff\1\171",
            "\1\172",
            "",
            "\1\173",
            "\1\174",
            "",
            "\1\175",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\177",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "",
            "",
            "\1\u0081",
            "",
            "",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0088",
            "",
            "",
            "\1\u008a",
            "",
            "",
            "\1\u008c",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008e",
            "\1\u008f",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0090",
            "\1\u0091",
            "",
            "",
            "",
            "\12\u0092",
            "\1\164\1\uffff\12\165",
            "",
            "",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "",
            "\1\u0099",
            "",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "",
            "",
            "",
            "",
            "\1\u00a1",
            "",
            "\1\u00a3\1\u00a2",
            "\1\u00a4",
            "\1\u00a5",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\u0092\14\uffff\1\u00a8\36\uffff\1\u00a7\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00b6",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00bb\1\uffff\1\u00bb",
            "",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c3\7\uffff\1\u00c2",
            "\1\u00c4",
            "\1\u00c5",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00c6",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00c8",
            "",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\12\u00cc",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00ce",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00d0",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\12\u00cc\14\uffff\1\u00a8\37\uffff\1\u00a8",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\1\u00dd",
            "",
            "",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00e4",
            "\1\u00e5",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\1\u00e9",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "\12\60\7\uffff\32\60\4\uffff\1\60\1\uffff\32\60",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | RULE_VERSION | RULE_BOOL | RULE_HEX | RULE_BINARY | RULE_DOUBLE | RULE_FLOAT | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA19_0 = input.LA(1);

                        s = -1;
                        if ( (LA19_0=='p') ) {s = 1;}

                        else if ( (LA19_0=='s') ) {s = 2;}

                        else if ( (LA19_0==';') ) {s = 3;}

                        else if ( (LA19_0=='i') ) {s = 4;}

                        else if ( (LA19_0=='a') ) {s = 5;}

                        else if ( (LA19_0==',') ) {s = 6;}

                        else if ( (LA19_0=='{') ) {s = 7;}

                        else if ( (LA19_0=='}') ) {s = 8;}

                        else if ( (LA19_0=='=') ) {s = 9;}

                        else if ( (LA19_0=='m') ) {s = 10;}

                        else if ( (LA19_0=='(') ) {s = 11;}

                        else if ( (LA19_0==')') ) {s = 12;}

                        else if ( (LA19_0=='_') ) {s = 13;}

                        else if ( (LA19_0=='f') ) {s = 14;}

                        else if ( (LA19_0=='e') ) {s = 15;}

                        else if ( (LA19_0=='r') ) {s = 16;}

                        else if ( (LA19_0=='.') ) {s = 17;}

                        else if ( (LA19_0==':') ) {s = 18;}

                        else if ( (LA19_0=='?') ) {s = 19;}

                        else if ( (LA19_0=='[') ) {s = 20;}

                        else if ( (LA19_0==']') ) {s = 21;}

                        else if ( (LA19_0=='<') ) {s = 22;}

                        else if ( (LA19_0=='>') ) {s = 23;}

                        else if ( (LA19_0=='n') ) {s = 24;}

                        else if ( (LA19_0=='&') ) {s = 25;}

                        else if ( (LA19_0=='|') ) {s = 26;}

                        else if ( (LA19_0=='!') ) {s = 27;}

                        else if ( (LA19_0=='^') ) {s = 28;}

                        else if ( (LA19_0=='c') ) {s = 29;}

                        else if ( (LA19_0=='l') ) {s = 30;}

                        else if ( (LA19_0=='*') ) {s = 31;}

                        else if ( (LA19_0=='/') ) {s = 32;}

                        else if ( (LA19_0=='%') ) {s = 33;}

                        else if ( (LA19_0=='+') ) {s = 34;}

                        else if ( (LA19_0=='-') ) {s = 35;}

                        else if ( (LA19_0=='~') ) {s = 36;}

                        else if ( (LA19_0=='t') ) {s = 37;}

                        else if ( (LA19_0=='y') ) {s = 38;}

                        else if ( (LA19_0=='0') ) {s = 39;}

                        else if ( ((LA19_0>='1' && LA19_0<='9')) ) {s = 40;}

                        else if ( ((LA19_0>='A' && LA19_0<='Z')||LA19_0=='b'||LA19_0=='d'||(LA19_0>='g' && LA19_0<='h')||(LA19_0>='j' && LA19_0<='k')||LA19_0=='o'||LA19_0=='q'||(LA19_0>='u' && LA19_0<='x')||LA19_0=='z') ) {s = 41;}

                        else if ( (LA19_0=='\"') ) {s = 42;}

                        else if ( (LA19_0=='\'') ) {s = 43;}

                        else if ( ((LA19_0>='\t' && LA19_0<='\n')||LA19_0=='\r'||LA19_0==' ') ) {s = 44;}

                        else if ( ((LA19_0>='\u0000' && LA19_0<='\b')||(LA19_0>='\u000B' && LA19_0<='\f')||(LA19_0>='\u000E' && LA19_0<='\u001F')||(LA19_0>='#' && LA19_0<='$')||LA19_0=='@'||LA19_0=='\\'||LA19_0=='`'||(LA19_0>='\u007F' && LA19_0<='\uFFFF')) ) {s = 45;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA19_42 = input.LA(1);

                        s = -1;
                        if ( ((LA19_42>='\u0000' && LA19_42<='\uFFFF')) ) {s = 118;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA19_43 = input.LA(1);

                        s = -1;
                        if ( ((LA19_43>='\u0000' && LA19_43<='\uFFFF')) ) {s = 118;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 19, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}