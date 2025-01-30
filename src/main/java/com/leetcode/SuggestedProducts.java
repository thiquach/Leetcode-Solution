package main.java.com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuggestedProducts {
    private TrieNode root;

    public static class TrieNode {
        boolean wordEnd;
        TrieNode[] children;

        public TrieNode() {
            this.wordEnd = false;
            this.children = new TrieNode[26]; // 26 letters of the alphabet
        }
    }

    SuggestedProducts() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
//        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
//        String searchWord = "mouse";
        String[] products = {"tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunqerptgas","zmmirsxdhyxvmdybjzondyvrkzeafhvualsivfueweuusmsxbttdeofzeripaqv","tyqcpfvorznmxxdzepfxabibcagilwjsqncxnpjqsxjzqqqbae","tyqcpfvacyrjvmadrmntxotgvgivdvcuwygpjfwcuppunolukrum","tyqcpfvrqwrcpusmfyhxaiasfbb","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqyalwiaj","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchidnpt","lfjkcljnd","zibrwfpwecubjlsjbkrhnvolnnzrqhdynloplzagwnuhpxhbvpxnqaifnln","ybswoottdgryxtupichpvqjmcoytrwnfgzrrnaejojvpzmttlzw","tyqcplghosxjviooiyddhvzzrhuuwkiosmgafxyajcdyqlmthqkoylxhtxdruw","okoscfpxcndzgbtsozdofgnomtglmoaewgzzjvrxezoq","cxkwvaytkxgafeltbanhsvxlorigkuxnsxlmhvwqm","iamtabcpdagicnvdvqcfykonsazrbdivxtczpgqgxjrifukmqjw","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbneryahanhrhkal","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunl","tyqcpfvorznmxxdzsuyushueegfrnlzbydnefcfagqnxglkulegntoml","zlovtmburfkd","vlzfaamutsfqefpafzffwhvpfw","bbufxzwpryyakbxuhwwplvdptgybbykqxirsrahsokviihxrawcbgwrktvgacmwtc","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbzw","kjundphljswl","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqhlqnapfkcqpdb","stcphvgxvcaysehvrfdfllwvxf","epbtkgnnupbbdqgheyaks","gilhnlfkdz","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwghy","yswdsvnzucvsdzrmeghevjrfuhoebfedvyvortaxppwqncmspctdcjlwdxfnc","baizdtmgozykukcrkapsnp","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgcsfjgtwqqubbhjkzmio","iblyydfzztmtyjmgrxvyjwcobfyxcgyrbtnfhhxswxahze","tyqcpfyggtmjahhpjzwhohvchyofsxwkehq","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniaymgkdduoabmp","gpsqlqorcbqffdxlnijgvzvxilnbkynwscuoymqyg","eidradnaqjwmucbrgtp","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzopnqxxcxshbhdmippldmcuxlvc","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbfmryrbgicgzqecje","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuze","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqandxbuvshebs","tyqcqqxonxtwakxlrceyknbockvovdwumbjkfrgmudiafbqlflonfavpsrfq","tyqcpfvorznmxxdzsnkjnrrzpfourbghe","ziarqmfvzqpqhunfxwfwjtetotozkjaszznbtrvtxarysaxq","tyqcpfvorznmxfmlzlcuikpxvahtfbfipjcgmeusshufvnirwcopdnvnop","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvdertpdpdjsngezrnyjxotgonuigmqkgipgb","tyqcpfvorznmxxdzsnkjnrrzpfvfcvufmzzuqrjubsfzp","tyqcpfvorznmxxdzsnkjnrrzpfgknvqorqffebhoyfvgkspenqpcmvoxpybkjg","oqojrvinnhlwuqllcsabkpfiusfucpjbsxzzhlgduawaqyp","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviaxsw","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqnzudhzclswotlbgdffwiekw","csgadyglxddodloklsegvsbtgtkloklmxkbxxyorcqwybktuzpyeaqasn","tyqitegmijccjwxuwvchbvuvllmgsdugzxdkiqvnllhmsjyskxpzzds","tyqcpfvorznigwmavbguxwhunsshdybhzszxvlnpingqgaghkqzeynbbbhgcxeydir","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunflh","tyqcpfvorznmbwmhfmudnurhismirfgvojpdmclw","tyqcpfvjijiwoup","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejemb","tyqcpfvorznmxxdzsnkjhvabtzucyooctzzrgehlsuyinrrnzjilfpalvqgwoey","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvie","tyqcpfvorznmxxxvjwfgcwegpibuifhfxyomnicutaegshpnschktxknqytritr","tyqcpfvorznetvhiaobezckojwjbeg","tyqcpfvorzmjabuccipqln","frutebajqddrtrsmabfmdcgipssymldwscxbbrbpb","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvqi","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchxeyrnlh","yaxaddctugikoutgcwqsdekghoemtooljxvysnzqqvgpc","tyqcpfvorznmxxdzsnkjn","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqggjwxdvqesbgrqei","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckoktdj","mzwjshgbgbdogqbrhfgbjkrqogyynbdwwkdclsbpynlrhxeucuuo","tyqcpfvorznmxxdzsnkjnrrztrqgpbvvxm","u","tyqcpfvorznmxjnsgyirdtzpwywpnrvgadkmdjghlmerbqysaebyge","tyqcpfvorznmxxdzsnkjnrkjelwoqorxsnyjqdnxfava","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvqqy","hcav","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviof","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwreznx","yesupowwycvcdbknhrkfyvnpoqtdhcbhybqvhnvgukoohh","hcvlnbmcrepblcqrvwpfsyevlpyldptubnxkntqhpounxjcw","lwaxzivycjkanvikqpbrvdvjkaclyuyfitwfycsnfwjg","tkruiswrcbzsbkwbhhvjzzuuiayqzbxjosjssacislcvbtcojpmyatkfgyx","ftujoohzvjonlwxwskeydoxpfvbvrdndbhgpuvykif","tyqcpfvorznmxxdzsnkjnrrzpfgknvqqngbpbdtufkgunalbekxbkpajlgbjtqmswh","tyqcpfvorznmxxdzsnkjnrrzpewgvvnicz","tyqcpfvorznmxxdzsnkjnrrzpfgknjxnepksgdzwxsbziwdzsiiyarxhtpp","jumcvboxaxjfybdlezcjrarolxjtsuweaigkiudusinfmnczdualqzlpwkm","tyqcpfvoxegnpqesbaugr","bteznmwyh","rtbpifxevchngjnlumvtqtpebgtoznvvrzfxqzmcktoxydbstbvukrunnyeqwfd","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejysfrlewzsgukyahggau","mvrrbfbfwyrxooopgcbwmtjfepejyfrqdkyaqencqqlagoilrtdndfyn","tyqcpfvorznmyrzwhjxvhooytltygrakvgkqumrimazzhzoueyqnjz","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviob","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwoyvqczogovza","tyqcpfvorznmxxdzsnkjnrrzpfgknvfnzshqqfpr","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjghvqg","zqrnaierpnsigujuxrftdiauazddadqmrwcimxyztwumwzyjcrqvuexnitdecfgo","xusxbbilivpovzsjvfsdnacipk","tyqcpfvorznmxxdzkbqgrgeolnwhtvlckmiattpmxwwtmlifnexxbgtpjslwhczrjlhr","eiuytvdzhcodcrdgthxynurtpsdyguupijjluucpfinrfnsjkdbbzexfmctejlgvd","tyqcpfudqjrabwwvdvwmsyscnazaxpsjjhetouegipqevvointclztzummwrrbntjlsj","tyqcpfvobzfvbiuoktjcqjfx","tyqcpfvorznmxxdzsnamc","ajqpomnpmsayhelmhfehjbvjaeszqigfqyuixbtyjy","jpfxangixfavlhcssecxljksydrjxmaldhwpftinywtbmffsmtslefcuddk","txryxhtutwdrqmpcapbcrlmhzsobueefwfekusmmylr","etzqiepphjcleaocnwljcdn","tyqcpfvokfxlbmbzmitacnromkoaoxl","iddmxxcmwecfutbrbqeihhlnypckofuhkbydmljfemzrvlxsuskxkbgviybzu","tyqcpfvorznmxxdzwilcfwrdlfqppdnuvgltuoooppwyomtvtggmsfxsxievdlsyame","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvzquhbkvburnhmerkuabrfcjwanzmfenz","tyqcpqgaus","zsbcqgctsjdjyfkdvcehawsqzacafwtjmhemfygdahkexvmkqkcehvek","tyqcpfvorznmxxdzsnkjfesxjshxtlinfjltdfl","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnubpoqoghhgbpew","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdcuudsuqq","tyqcpgwivyfquxqhbkjbioekqbsd","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnudxocavmwpggka","tyqcpfvorznmxxdzsnkjnrrzpfgknvnlxdokehsjhiohwdeyikeajzipztzhwmxc","pmpoycdxttisazazsgiswnsnhdmejpjbygvtjhwqydeugbouekvornbeiwmpehikbz","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwcpoxr","qmgnrjtavzsqtwareroiihendgcvbzbcolvfoanmixxrxdtnmtevvv","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnunix","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetxpdyhmk","tyqcpfvorznmxxdzsnkjnrfmy","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetaoqgbczdcemzlmqemy","tyqcpfzmlffhifutomuvfvwaqatopvur","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvdvagddprewvlgx","ozmyertmnlwybntwxmpynuynhqdbqhosvjwexzqgvdtnvxexxwwwwhqktmzbfkjfn","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckohyof","rniiqnzbctzeyeeyrxhfzqgbccplsncvtswcrqmevplfzadlulazmpmhdojwaokn","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzakckmtmjxx","tyqcpfvorznmxxdzsnkjnrrzpfgkhdwienfhpsqbyrvotbgchkkmvk","tyqcpfvorznmxxdzsnkjnrrumaqtylptffsjzygeumkahutdmalkqtrhtgrsrqcyyti","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvioncnr","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchvigzpo","tyqcpfvorznmxxdzsnkjnrrzpfgkeduq","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnccdnakfkhtg","lhehmbyzcnlwvr","tyqcpfvojuuprlby","wds","tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqvegfwmtdcrvdb","tyqcpfvorznpkeynkmbbyptclmhxxlyjzejqbcatgfrmkbbmxs","tyqcpfvorznmiqmfrhihxsagizcrwyaukrjwbbgrxdzknq","ghhlssixrouzbqcpmxzmsnybaygtb","jndewk","tyqcpfvorznmxxdzsnkjnrrzpdqanmxattjhgnflnoyynevsxvpbwfmfrnlc"};
        String searchWord = "tyqcpfvorznmxxdzsnkjnrrzpfgknvqvderckuzdqqgaqejetbnuniwwjbdchviotvdticwxwcliylrpvrokbcguhnfvpd";
        System.out.println("suggested products " + suggestedProducts(products, searchWord));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if (products == null) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        Arrays.sort(products);

        int length = products.length;
        int left = 0;
        int right = length - 1;
        for (int i=0; i<searchWord.length(); i++) {
            char ch = searchWord.charAt(i);

            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != ch)) {
                left++;
            }
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != ch)) {
                right--;
            }

            int remain = Math.min(right - left + 1, 3);
            List<String> list = new ArrayList<>();
            for (int j=0; j<remain; j++) {
                list.add(products[left+j]);
            }
            result.add(list);
        }
        return result;
    }
}