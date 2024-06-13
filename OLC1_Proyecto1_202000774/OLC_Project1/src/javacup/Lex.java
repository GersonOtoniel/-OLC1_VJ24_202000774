// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: src/javacup/Lexer.jflex

package javacup;
import java.io.*;
import java_cup.runtime.*;



@SuppressWarnings("fallthrough")
public class Lex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int COMMENT = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\36\u0200\1\u0300\1\u0400\266\u0200\10\u0500\u1020\u0200";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\2\2\22\0\1\1\1\4"+
    "\1\5\2\0\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\12\21\1\22\1\23"+
    "\1\24\1\25\1\26\2\0\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\40\1\43\1\44\1\45\1\40\1\46\1\47\1\50"+
    "\1\51\1\52\1\53\3\40\1\54\1\55\1\56\1\57"+
    "\1\60\1\0\1\27\1\61\1\31\1\32\1\33\1\62"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\40\1\63"+
    "\1\44\1\45\1\40\1\64\1\47\1\65\1\51\1\52"+
    "\1\53\3\40\1\66\1\67\1\70\7\0\1\3\252\0"+
    "\2\71\115\0\1\72\u01a8\0\2\3\u0100\0\1\73\325\0"+
    "\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1536];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\3\1\1\1\4\2\1\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\14\22\1\23\1\1\1\24"+
    "\1\25\1\26\1\27\1\1\1\30\14\1\1\31\1\0"+
    "\1\32\1\0\1\33\1\0\1\34\1\0\1\35\1\36"+
    "\1\37\1\0\1\2\1\0\1\40\1\41\1\42\10\22"+
    "\1\43\6\22\2\0\1\44\1\43\16\0\1\32\5\0"+
    "\1\45\6\22\1\0\1\46\1\22\1\47\1\22\1\0"+
    "\2\22\1\50\1\22\3\0\1\47\6\0\1\46\2\0"+
    "\1\50\1\0\1\32\1\0\1\34\2\0\1\2\1\45"+
    "\1\51\1\22\1\52\1\22\1\0\1\22\2\53\1\22"+
    "\1\0\1\22\1\0\1\22\1\0\1\54\1\22\2\0"+
    "\1\51\1\0\1\52\1\0\1\54\2\0\1\32\3\0"+
    "\1\2\2\55\1\22\1\56\1\0\1\56\1\22\2\57"+
    "\1\22\1\0\1\22\1\0\2\60\5\0\1\22\1\0"+
    "\1\61\1\22\1\0\2\62\1\0\1\61\2\63\2\64"+
    "\47\0";

  private static int [] zzUnpackAction() {
    int [] result = new int[251];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\74\0\170\0\264\0\360\0\u012c\0\170\0\u0168"+
    "\0\u01a4\0\170\0\170\0\u01e0\0\u021c\0\170\0\u0258\0\u0294"+
    "\0\u02d0\0\170\0\170\0\u030c\0\u0348\0\u0384\0\u03c0\0\u03fc"+
    "\0\u0438\0\u0474\0\u04b0\0\u04ec\0\u0528\0\u0564\0\u05a0\0\u05dc"+
    "\0\u0618\0\u0654\0\u0690\0\u06cc\0\170\0\170\0\170\0\170"+
    "\0\u0708\0\170\0\u0744\0\u0780\0\u0294\0\u07bc\0\u07f8\0\u0834"+
    "\0\u0870\0\u08ac\0\u08e8\0\u0924\0\u0960\0\u099c\0\170\0\u09d8"+
    "\0\u0a14\0\u0a50\0\170\0\u01a4\0\170\0\u0a8c\0\170\0\170"+
    "\0\170\0\u0ac8\0\u0b04\0\u0b40\0\170\0\170\0\170\0\u0b7c"+
    "\0\u0bb8\0\u0bf4\0\u0c30\0\u0c6c\0\u0ca8\0\u0ce4\0\u0d20\0\u03c0"+
    "\0\u0d5c\0\u0d98\0\u0dd4\0\u0e10\0\u0e4c\0\u0e88\0\u0ec4\0\u0f00"+
    "\0\170\0\170\0\u0f3c\0\u0f78\0\u0fb4\0\u0ff0\0\u102c\0\u1068"+
    "\0\u10a4\0\u10e0\0\u111c\0\u1158\0\u1194\0\u11d0\0\u120c\0\u1248"+
    "\0\170\0\u1284\0\u12c0\0\u12fc\0\u1338\0\u1374\0\u13b0\0\u13ec"+
    "\0\u1428\0\u1464\0\u14a0\0\u14dc\0\u1518\0\u1554\0\u03c0\0\u1590"+
    "\0\u03c0\0\u15cc\0\u1608\0\u1644\0\u1680\0\u03c0\0\u16bc\0\u16f8"+
    "\0\u1734\0\u1770\0\170\0\u17ac\0\u17e8\0\u1824\0\u1860\0\u189c"+
    "\0\u18d8\0\170\0\u1914\0\u1950\0\170\0\u198c\0\u19c8\0\u1a04"+
    "\0\u1a40\0\u1a7c\0\u1ab8\0\170\0\u1af4\0\u03c0\0\u1b30\0\u03c0"+
    "\0\u1b6c\0\u1ba8\0\u1be4\0\u03c0\0\170\0\u1c20\0\u1c5c\0\u1c98"+
    "\0\u1cd4\0\u1d10\0\u1d4c\0\u03c0\0\u1d88\0\u1dc4\0\u1e00\0\170"+
    "\0\u1e3c\0\170\0\u1e78\0\170\0\u19c8\0\u1eb4\0\u1284\0\u1ef0"+
    "\0\u1a40\0\u1f2c\0\u1a7c\0\u03c0\0\170\0\u1f68\0\u03c0\0\u1fa4"+
    "\0\170\0\u1fe0\0\u03c0\0\170\0\u201c\0\u2058\0\u2094\0\u20d0"+
    "\0\u03c0\0\170\0\u210c\0\u2148\0\u2184\0\u21c0\0\u21fc\0\u2238"+
    "\0\u2274\0\u03c0\0\u22b0\0\u22ec\0\u03c0\0\170\0\u2328\0\170"+
    "\0\u03c0\0\170\0\u03c0\0\170\0\u2364\0\u23a0\0\u23dc\0\u2418"+
    "\0\u2454\0\u2490\0\u24cc\0\u2508\0\u2544\0\u2580\0\u25bc\0\u25f8"+
    "\0\u2634\0\u2670\0\u26ac\0\u26e8\0\u2724\0\u2760\0\u279c\0\u27d8"+
    "\0\u2814\0\u2850\0\u288c\0\u28c8\0\u2904\0\u2940\0\u297c\0\u29b8"+
    "\0\u29f4\0\u2a30\0\u2a6c\0\u2aa8\0\u2ae4\0\u2b20\0\u2b5c\0\u2b98"+
    "\0\u2bd4\0\u2c10\0\u2c4c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[251];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\2\4\1\0\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\3\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\2\27\1\35\5\27\1\36"+
    "\1\27\1\37\1\40\1\27\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\30\1\34\2\27\1\40\1\50"+
    "\1\51\1\52\1\53\1\54\2\3\2\4\1\0\14\3"+
    "\1\55\7\3\1\56\1\57\1\60\1\61\1\62\2\3"+
    "\1\53\5\3\1\63\1\3\1\54\1\64\1\3\1\65"+
    "\1\66\5\3\1\56\1\62\2\3\1\64\3\3\1\53"+
    "\1\54\1\3\75\0\2\4\116\0\1\67\46\0\5\70"+
    "\1\71\47\70\1\72\16\70\7\0\1\73\64\0\10\74"+
    "\1\75\44\74\1\76\16\74\13\0\1\77\74\0\1\100"+
    "\75\0\1\101\70\0\1\102\4\0\1\103\72\0\1\104"+
    "\1\0\1\21\77\0\1\105\73\0\1\106\73\0\1\107"+
    "\67\0\1\27\5\0\25\27\5\0\5\27\27\0\1\27"+
    "\5\0\15\27\1\110\1\27\1\111\5\27\5\0\3\27"+
    "\1\111\1\27\27\0\1\27\5\0\7\27\1\112\5\27"+
    "\1\113\7\27\5\0\5\27\27\0\1\27\5\0\15\27"+
    "\1\114\7\27\5\0\5\27\27\0\1\27\5\0\13\27"+
    "\1\115\1\116\10\27\5\0\2\27\1\116\2\27\27\0"+
    "\1\27\5\0\1\117\24\27\5\0\5\27\27\0\1\27"+
    "\5\0\5\27\1\120\6\27\1\121\10\27\5\0\1\27"+
    "\1\120\1\121\2\27\27\0\1\27\5\0\17\27\1\122"+
    "\5\27\5\0\3\27\1\122\1\27\27\0\1\27\5\0"+
    "\21\27\1\123\3\27\5\0\4\27\1\123\27\0\1\27"+
    "\5\0\17\27\1\124\5\27\5\0\3\27\1\124\1\27"+
    "\27\0\1\27\5\0\1\125\24\27\5\0\5\27\27\0"+
    "\1\27\5\0\7\27\1\126\15\27\5\0\5\27\65\0"+
    "\1\127\25\0\1\130\151\0\1\131\40\0\1\132\6\0"+
    "\1\133\16\0\1\132\1\133\60\0\1\134\14\0\1\134"+
    "\52\0\1\135\1\0\1\136\15\0\1\136\45\0\1\137"+
    "\5\0\1\140\73\0\1\141\71\0\1\142\1\143\17\0"+
    "\1\143\37\0\1\144\112\0\1\145\15\0\1\145\55\0"+
    "\1\146\15\0\1\146\36\0\1\147\102\0\1\150\35\0"+
    "\5\70\1\151\47\70\1\72\16\70\5\0\1\151\73\0"+
    "\1\152\2\0\1\152\44\0\1\153\3\0\5\152\6\0"+
    "\10\154\1\75\44\154\1\155\16\154\13\102\1\156\60\102"+
    "\2\103\2\0\70\103\21\0\1\157\73\0\1\27\5\0"+
    "\15\27\1\160\7\27\5\0\5\27\27\0\1\27\5\0"+
    "\4\27\1\161\20\27\5\0\5\27\27\0\1\27\5\0"+
    "\1\162\24\27\5\0\5\27\27\0\1\27\5\0\14\27"+
    "\1\163\10\27\5\0\2\27\1\163\2\27\27\0\1\27"+
    "\5\0\22\27\1\164\2\27\5\0\5\27\27\0\1\27"+
    "\5\0\20\27\1\165\4\27\5\0\5\27\4\0\1\166"+
    "\22\0\1\27\5\0\3\27\1\167\21\27\5\0\5\27"+
    "\27\0\1\27\5\0\13\27\1\170\11\27\5\0\5\27"+
    "\27\0\1\27\5\0\21\27\1\171\3\27\5\0\4\27"+
    "\1\171\27\0\1\27\5\0\10\27\1\172\14\27\5\0"+
    "\5\27\3\0\1\173\23\0\1\27\5\0\17\27\1\174"+
    "\5\27\5\0\3\27\1\174\1\27\27\0\1\27\5\0"+
    "\22\27\1\175\2\27\5\0\5\27\27\0\1\27\5\0"+
    "\17\27\1\176\5\27\5\0\3\27\1\176\1\27\27\0"+
    "\1\27\5\0\10\27\1\177\14\27\5\0\5\27\3\0"+
    "\1\200\60\0\1\201\26\0\1\202\132\0\1\203\14\0"+
    "\1\203\54\0\1\204\15\0\1\204\53\0\1\205\62\0"+
    "\1\206\67\0\1\207\107\0\1\210\17\0\1\210\61\0"+
    "\1\211\71\0\1\166\22\0\1\166\33\0\1\212\103\0"+
    "\1\213\70\0\1\173\31\0\1\173\53\0\1\214\70\0"+
    "\1\215\15\0\1\215\46\0\1\200\31\0\1\200\2\0"+
    "\5\152\1\151\47\152\1\216\16\152\2\70\2\152\1\70"+
    "\1\217\47\70\1\220\16\70\10\154\1\75\63\154\2\74"+
    "\2\154\4\74\1\221\63\74\13\222\1\223\4\222\1\224"+
    "\53\222\21\0\1\225\73\0\1\27\5\0\13\27\1\226"+
    "\11\27\5\0\5\27\27\0\1\27\5\0\1\227\24\27"+
    "\5\0\5\27\27\0\1\27\5\0\17\27\1\230\5\27"+
    "\5\0\3\27\1\230\1\27\27\0\1\27\5\0\20\27"+
    "\1\231\4\27\5\0\5\27\4\0\1\232\22\0\1\27"+
    "\5\0\1\27\1\233\23\27\5\0\1\233\4\27\27\0"+
    "\1\27\5\0\4\27\1\234\20\27\5\0\5\27\41\0"+
    "\1\235\61\0\1\27\5\0\20\27\1\236\4\27\5\0"+
    "\5\27\4\0\1\237\22\0\1\27\5\0\14\27\1\240"+
    "\10\27\5\0\2\27\1\240\2\27\51\0\1\241\17\0"+
    "\1\241\31\0\1\27\5\0\10\27\1\242\14\27\5\0"+
    "\5\27\3\0\1\243\23\0\1\27\5\0\4\27\1\244"+
    "\20\27\5\0\5\27\27\0\1\27\5\0\13\27\1\245"+
    "\11\27\5\0\5\27\50\0\1\246\44\0\1\151\134\0"+
    "\1\247\56\0\1\243\31\0\1\243\44\0\1\250\60\0"+
    "\1\251\112\0\1\252\15\0\1\252\56\0\1\232\22\0"+
    "\1\232\31\0\1\253\30\0\1\253\61\0\1\237\22\0"+
    "\1\237\34\0\1\254\45\0\1\152\2\0\1\152\44\0"+
    "\1\152\3\0\5\152\6\0\5\255\1\151\47\255\1\256"+
    "\23\255\1\257\2\255\1\70\44\255\1\260\3\255\5\70"+
    "\6\255\10\261\1\75\44\261\1\262\16\261\13\222\1\223"+
    "\73\222\1\223\4\222\1\263\53\222\17\0\1\104\1\0"+
    "\1\225\73\0\1\27\5\0\12\27\1\264\12\27\5\0"+
    "\5\27\5\0\1\265\21\0\1\27\5\0\15\27\1\266"+
    "\3\27\1\267\3\27\5\0\4\27\1\267\52\0\1\270"+
    "\3\0\1\271\14\0\1\271\27\0\1\27\5\0\13\27"+
    "\1\272\11\27\5\0\5\27\27\0\1\27\5\0\4\27"+
    "\1\273\20\27\5\0\5\27\41\0\1\274\61\0\1\27"+
    "\5\0\21\27\1\275\3\27\5\0\4\27\1\275\56\0"+
    "\1\276\14\0\1\276\27\0\1\27\5\0\14\27\1\277"+
    "\10\27\5\0\2\27\1\277\2\27\51\0\1\300\17\0"+
    "\1\300\31\0\1\27\5\0\4\27\1\301\20\27\5\0"+
    "\5\27\41\0\1\302\117\0\1\303\55\0\1\265\31\0"+
    "\1\265\42\0\1\304\106\0\1\305\16\0\5\152\1\151"+
    "\47\152\1\306\16\152\55\0\1\307\37\0\1\27\5\0"+
    "\13\27\1\310\11\27\5\0\5\27\50\0\1\311\52\0"+
    "\1\27\5\0\4\27\1\312\20\27\5\0\5\27\27\0"+
    "\1\27\5\0\13\27\1\313\11\27\5\0\5\27\50\0"+
    "\1\314\52\0\1\27\5\0\6\27\1\315\16\27\5\0"+
    "\5\27\43\0\1\316\43\0\1\317\121\0\1\320\40\0"+
    "\2\255\2\0\72\255\2\0\1\255\1\70\2\255\1\70"+
    "\44\255\1\70\3\255\5\70\6\255\2\261\2\0\70\261"+
    "\21\0\1\27\5\0\4\27\1\321\20\27\5\0\5\27"+
    "\41\0\1\322\61\0\1\27\5\0\14\27\1\323\10\27"+
    "\5\0\2\27\1\323\2\27\51\0\1\324\17\0\1\324"+
    "\65\0\1\325\73\0\1\326\61\0\1\327\17\0\1\327"+
    "\66\0\1\330\104\0\1\331\61\0\1\332\73\0\1\333"+
    "\61\0\1\334\17\0\1\334\77\0\1\335\61\0\1\336"+
    "\73\0\1\337\73\0\1\340\73\0\1\341\61\0\1\342"+
    "\17\0\1\342\77\0\1\343\61\0\1\344\73\0\1\345"+
    "\23\0\1\346\73\0\1\347\155\0\1\350\61\0\1\351"+
    "\73\0\1\352\73\0\1\353\73\0\1\354\61\0\1\355"+
    "\17\0\1\355\77\0\1\356\61\0\1\357\73\0\1\360"+
    "\35\0\1\361\130\0\1\362\76\0\1\363\21\0\1\364"+
    "\143\0\1\365\73\0\1\366\61\0\1\367\17\0\1\367"+
    "\66\0\1\370\27\0\1\371\74\0\1\372\72\0\1\373"+
    "\136\0\1\151\16\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[11400];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\11\3\1\1\11\2\1\2\11\2\1\1\11"+
    "\3\1\2\11\21\1\4\11\1\1\1\11\14\1\1\11"+
    "\1\0\1\1\1\0\1\11\1\0\1\11\1\0\3\11"+
    "\1\0\1\1\1\0\3\11\17\1\2\0\2\11\16\0"+
    "\1\11\5\0\7\1\1\0\4\1\1\0\4\1\3\0"+
    "\1\11\6\0\1\11\2\0\1\11\1\0\1\1\1\0"+
    "\1\1\2\0\1\11\5\1\1\0\2\1\1\11\1\1"+
    "\1\0\1\1\1\0\1\1\1\0\2\1\2\0\1\11"+
    "\1\0\1\11\1\0\1\11\2\0\1\1\3\0\2\1"+
    "\1\11\2\1\1\0\1\11\2\1\1\11\1\1\1\0"+
    "\1\1\1\0\1\1\1\11\5\0\1\1\1\0\2\1"+
    "\1\0\1\1\1\11\1\0\1\11\1\1\1\11\1\1"+
    "\1\11\47\0";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[251];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
	StringBuffer string = new StringBuffer();
	
	private Symbol Symbol(int type){
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol Symbol(int type, Object value){
		return new Symbol(type, yyline, yycolumn, value);
	}


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lex(java.io.Reader in) {
      yyline=1;
    yycolumn=1;
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {     return Symbol(sym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.err.println("Warning: unrecognized character " + yytext());
            }
          // fall through
          case 53: break;
          case 2:
            { /*Ignore*/
            }
          // fall through
          case 54: break;
          case 3:
            { return new Symbol (sym.NOT, yyline, yycolumn, yytext());
            }
          // fall through
          case 55: break;
          case 4:
            { return new Symbol (sym.MODULO, yyline, yycolumn, yytext());
            }
          // fall through
          case 56: break;
          case 5:
            { return new Symbol (sym.PARENABRE, yyline, yycolumn,yytext());
            }
          // fall through
          case 57: break;
          case 6:
            { return new Symbol (sym.PARENCIERRA, yyline, yycolumn,yytext());
            }
          // fall through
          case 58: break;
          case 7:
            { return new Symbol (sym.MULTIPLICACION, yyline, yycolumn, yytext());
            }
          // fall through
          case 59: break;
          case 8:
            { return new Symbol (sym.SUMA, yyline,yycolumn,yytext());
            }
          // fall through
          case 60: break;
          case 9:
            { return new Symbol (sym.COMA, yyline, yycolumn,yytext());
            }
          // fall through
          case 61: break;
          case 10:
            { return new Symbol (sym.MENOS, yyline,yycolumn,yytext());
            }
          // fall through
          case 62: break;
          case 11:
            { return new Symbol (sym.DIVISION, yyline, yycolumn, yytext());
            }
          // fall through
          case 63: break;
          case 12:
            { return new Symbol (sym.ENTERO, yyline, yycolumn, yytext());
            }
          // fall through
          case 64: break;
          case 13:
            { return new Symbol (sym.DP, yyline, yycolumn,yytext());
            }
          // fall through
          case 65: break;
          case 14:
            { return new Symbol (sym.PYC, yyline, yycolumn,yytext());
            }
          // fall through
          case 66: break;
          case 15:
            { return new Symbol (sym.MENORQ, yyline, yycolumn, yytext());
            }
          // fall through
          case 67: break;
          case 16:
            { return new Symbol (sym.IGUAL, yyline,yycolumn,yytext());
            }
          // fall through
          case 68: break;
          case 17:
            { return new Symbol (sym.MAYORQ, yyline, yycolumn, yytext());
            }
          // fall through
          case 69: break;
          case 18:
            { return new Symbol (sym.ID, yyline,yycolumn,yytext());
            }
          // fall through
          case 70: break;
          case 19:
            { return new Symbol (sym.CORCHABRE, yyline, yycolumn,yytext());
            }
          // fall through
          case 71: break;
          case 20:
            { return new Symbol (sym.CORCHCIERRA, yyline, yycolumn,yytext());
            }
          // fall through
          case 72: break;
          case 21:
            { return new Symbol (sym.XOR, yyline, yycolumn, yytext());
            }
          // fall through
          case 73: break;
          case 22:
            { return new Symbol (sym.UNDERSCORE, yyline, yycolumn,yytext());
            }
          // fall through
          case 74: break;
          case 23:
            { return new Symbol (sym.CORCHABRE, yyline, yycolumn, yytext());
            }
          // fall through
          case 75: break;
          case 24:
            { return new Symbol (sym.CORCHCIERRA, yyline, yycolumn, yytext());
            }
          // fall through
          case 76: break;
          case 25:
            { return new Symbol (sym.DIFERENTE, yyline, yycolumn, yytext());
            }
          // fall through
          case 77: break;
          case 26:
            { return new Symbol (sym.STRING, yyline, yycolumn,yytext());
            }
          // fall through
          case 78: break;
          case 27:
            { return new Symbol (sym.AND, yyline, yycolumn, yytext());
            }
          // fall through
          case 79: break;
          case 28:
            { return new Symbol (sym.TKCHAR, yyline, yycolumn, yytext());
            }
          // fall through
          case 80: break;
          case 29:
            { return new Symbol (sym.POTENCIA, yyline, yycolumn, yytext());
            }
          // fall through
          case 81: break;
          case 30:
            { return new Symbol (sym.INC, yyline, yycolumn, yytext());
            }
          // fall through
          case 82: break;
          case 31:
            { return new Symbol (sym.DEC, yyline, yycolumn, yytext());
            }
          // fall through
          case 83: break;
          case 32:
            { return new Symbol (sym.MENORIGUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 84: break;
          case 33:
            { return new Symbol (sym.IGUALACION, yyline, yycolumn, yytext());
            }
          // fall through
          case 85: break;
          case 34:
            { return new Symbol (sym.MAYORIGUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 86: break;
          case 35:
            { return new Symbol (sym.TKIF, yyline, yycolumn, yytext());
            }
          // fall through
          case 87: break;
          case 36:
            { return new Symbol (sym.OR, yyline, yycolumn, yytext());
            }
          // fall through
          case 88: break;
          case 37:
            { return new Symbol (sym.DECIMAL, yyline, yycolumn,yytext());
            }
          // fall through
          case 89: break;
          case 38:
            { return new Symbol (sym.END,yyline, yycolumn, yytext());
            }
          // fall through
          case 90: break;
          case 39:
            { return new Symbol (sym.INT, yyline, yycolumn, yytext());
            }
          // fall through
          case 91: break;
          case 40:
            { return new Symbol (sym.VAR, yyline, yycolumn,yytext());
            }
          // fall through
          case 92: break;
          case 41:
            { return new Symbol (sym.BOOL, yyline, yycolumn, yytext());
            }
          // fall through
          case 93: break;
          case 42:
            { return new Symbol (sym.CHAR, yyline, yycolumn, yytext());
            }
          // fall through
          case 94: break;
          case 43:
            { return new Symbol (sym.ELSE, yyline, yycolumn, yytext());
            }
          // fall through
          case 95: break;
          case 44:
            { return new Symbol (sym.TRUE, yyline, yycolumn, yytext());
            }
          // fall through
          case 96: break;
          case 45:
            { return new Symbol (sym.TKBREAK, yyline, yycolumn, yytext());
            }
          // fall through
          case 97: break;
          case 46:
            { return new Symbol (sym.CONST, yyline, yycolumn, yytext());
            }
          // fall through
          case 98: break;
          case 47:
            { return new Symbol (sym.FALSE, yyline, yycolumn, yytext());
            }
          // fall through
          case 99: break;
          case 48:
            { return new Symbol (sym.WHILE, yyline, yycolumn, yytext());
            }
          // fall through
          case 100: break;
          case 49:
            { return new Symbol (sym.DOUBLE,yyline, yycolumn,yytext());
            }
          // fall through
          case 101: break;
          case 50:
            { return new Symbol (sym.TKSTRING, yyline, yycolumn, yytext());
            }
          // fall through
          case 102: break;
          case 51:
            { return new Symbol (sym.CONSOLE, yyline, yycolumn, yytext());
            }
          // fall through
          case 103: break;
          case 52:
            { return new Symbol (sym.PRINTLN, yyline, yycolumn, yytext());
            }
          // fall through
          case 104: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}