// Generated from C:/Users/George/Desktop/Project/AntlrApplication/antlr-src\JSON.g4 by ANTLR 4.12.0
package com.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JSONLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		STRING=10, NUMBER=11, DIGIT=12, INTEGER=13, FRACTION=14, EXPONENT=15, 
		WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"STRING", "NUMBER", "DIGIT", "INTEGER", "FRACTION", "EXPONENT", "SCHAR", 
			"TEXT", "UNICODE", "HEX", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'true'", "'false'", "'null'", "'{'", "','", "'}'", "'['", "']'", 
			"':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "STRING", 
			"NUMBER", "DIGIT", "INTEGER", "FRACTION", "EXPONENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public JSONLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JSON.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010\u0085\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\tI\b\t\n\t\f\tL\t\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0003\nR\b\n\u0001\u000b\u0003\u000bU\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bZ\b\u000b\u0001\f\u0004"+
		"\f]\b\f\u000b\f\f\f^\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000eh\b\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000el\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000fs\b\u000f\u0001\u0010\u0004\u0010v\b\u0010\u000b\u0010"+
		"\f\u0010w\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0000\u0000\u0014\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0000!\u0000#\u0000%\u0000"+
		"\'\u0010\u0001\u0000\u0007\u0001\u000009\u0002\u0000EEee\u0002\u0000+"+
		"+--\u0007\u0000\"\"\\\\bbffnnrrtt\u0002\u0000\"\"\\\\\u0003\u000009AF"+
		"af\u0003\u0000\t\n\r\r  \u008b\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0001)\u0001\u0000\u0000\u0000\u0003.\u0001\u0000\u0000\u0000"+
		"\u00054\u0001\u0000\u0000\u0000\u00079\u0001\u0000\u0000\u0000\t;\u0001"+
		"\u0000\u0000\u0000\u000b=\u0001\u0000\u0000\u0000\r?\u0001\u0000\u0000"+
		"\u0000\u000fA\u0001\u0000\u0000\u0000\u0011C\u0001\u0000\u0000\u0000\u0013"+
		"E\u0001\u0000\u0000\u0000\u0015Q\u0001\u0000\u0000\u0000\u0017T\u0001"+
		"\u0000\u0000\u0000\u0019\\\u0001\u0000\u0000\u0000\u001b`\u0001\u0000"+
		"\u0000\u0000\u001dd\u0001\u0000\u0000\u0000\u001fo\u0001\u0000\u0000\u0000"+
		"!u\u0001\u0000\u0000\u0000#y\u0001\u0000\u0000\u0000%\u007f\u0001\u0000"+
		"\u0000\u0000\'\u0081\u0001\u0000\u0000\u0000)*\u0005t\u0000\u0000*+\u0005"+
		"r\u0000\u0000+,\u0005u\u0000\u0000,-\u0005e\u0000\u0000-\u0002\u0001\u0000"+
		"\u0000\u0000./\u0005f\u0000\u0000/0\u0005a\u0000\u000001\u0005l\u0000"+
		"\u000012\u0005s\u0000\u000023\u0005e\u0000\u00003\u0004\u0001\u0000\u0000"+
		"\u000045\u0005n\u0000\u000056\u0005u\u0000\u000067\u0005l\u0000\u0000"+
		"78\u0005l\u0000\u00008\u0006\u0001\u0000\u0000\u00009:\u0005{\u0000\u0000"+
		":\b\u0001\u0000\u0000\u0000;<\u0005,\u0000\u0000<\n\u0001\u0000\u0000"+
		"\u0000=>\u0005}\u0000\u0000>\f\u0001\u0000\u0000\u0000?@\u0005[\u0000"+
		"\u0000@\u000e\u0001\u0000\u0000\u0000AB\u0005]\u0000\u0000B\u0010\u0001"+
		"\u0000\u0000\u0000CD\u0005:\u0000\u0000D\u0012\u0001\u0000\u0000\u0000"+
		"EJ\u0005\"\u0000\u0000FI\u0003\u001f\u000f\u0000GI\u0003!\u0010\u0000"+
		"HF\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000"+
		"\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000"+
		"\u0000\u0000LJ\u0001\u0000\u0000\u0000MN\u0005\"\u0000\u0000N\u0014\u0001"+
		"\u0000\u0000\u0000OR\u00050\u0000\u0000PR\u0003\u0017\u000b\u0000QO\u0001"+
		"\u0000\u0000\u0000QP\u0001\u0000\u0000\u0000R\u0016\u0001\u0000\u0000"+
		"\u0000SU\u0005-\u0000\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000"+
		"\u0000UY\u0001\u0000\u0000\u0000VZ\u0003\u0019\f\u0000WZ\u0003\u001b\r"+
		"\u0000XZ\u0003\u001d\u000e\u0000YV\u0001\u0000\u0000\u0000YW\u0001\u0000"+
		"\u0000\u0000YX\u0001\u0000\u0000\u0000Z\u0018\u0001\u0000\u0000\u0000"+
		"[]\u0007\u0000\u0000\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u001a\u0001"+
		"\u0000\u0000\u0000`a\u0003\u0019\f\u0000ab\u0005.\u0000\u0000bc\u0003"+
		"\u0019\f\u0000c\u001c\u0001\u0000\u0000\u0000dg\u0003\u0019\f\u0000ef"+
		"\u0005.\u0000\u0000fh\u0003\u0019\f\u0000ge\u0001\u0000\u0000\u0000gh"+
		"\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0007\u0001\u0000"+
		"\u0000jl\u0007\u0002\u0000\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0003\u0019\f\u0000n\u001e\u0001"+
		"\u0000\u0000\u0000or\u0005\\\u0000\u0000ps\u0007\u0003\u0000\u0000qs\u0003"+
		"#\u0011\u0000rp\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000s \u0001"+
		"\u0000\u0000\u0000tv\b\u0004\u0000\u0000ut\u0001\u0000\u0000\u0000vw\u0001"+
		"\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"x\"\u0001\u0000\u0000\u0000yz\u0005u\u0000\u0000z{\u0003%\u0012\u0000"+
		"{|\u0003%\u0012\u0000|}\u0003%\u0012\u0000}~\u0003%\u0012\u0000~$\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0007\u0005\u0000\u0000\u0080&\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0007\u0006\u0000\u0000\u0082\u0083\u0001\u0000"+
		"\u0000\u0000\u0083\u0084\u0006\u0013\u0000\u0000\u0084(\u0001\u0000\u0000"+
		"\u0000\u000b\u0000HJQTY^gkrw\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}