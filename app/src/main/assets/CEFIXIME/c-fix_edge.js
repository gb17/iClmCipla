/**
 * Adobe Edge: symbol definitions
 */
(function($, Edge, compId){
//images folder
var im='images/';

var fonts = {};
var opts = {
    'gAudioPreloadPreference': 'auto',

    'gVideoPreloadPreference': 'auto'
};
var resources = [
];
var symbols = {
"stage": {
    version: "4.0.0",
    minimumCompatibleVersion: "4.0.0",
    build: "4.0.0.359",
    baseState: "Base State",
    scaleToFit: "width",
    centerStage: "both",
    initialState: "Base State",
    gpuAccelerate: false,
    resizeInstances: false,
    content: {
            dom: [
            {
                id: 'bg',
                type: 'image',
                rect: ['0', '0','1280px','727px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"bg.jpg",'0px','0px']
            },
            {
                id: 'taxt_2',
                type: 'image',
                rect: ['202px', '557px','721px','137px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"taxt_2.png",'0px','0px']
            },
            {
                id: 'taxt_1',
                type: 'image',
                rect: ['0px', '230px','1280px','266px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"taxt_1.png",'0px','0px']
            },
            {
                id: 'patch_1',
                type: 'image',
                rect: ['715px', '412px','565px','83px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"patch_1.png",'0px','0px']
            },
            {
                id: 'patch_2',
                type: 'image',
                rect: ['715px', '495px','565px','83px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"patch_2.png",'0px','0px']
            },
            {
                id: 'patch_text',
                type: 'image',
                rect: ['820px', '430px','226px','46px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"patch_text.png",'0px','0px']
            },
            {
                id: 'patch_text1',
                type: 'image',
                rect: ['820px', '519px','126px','37px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"patch_text1.png",'0px','0px']
            },
            {
                id: 'arrow',
                type: 'image',
                rect: ['756px', '432px','21px','44px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"arrow.png",'0px','0px']
            },
            {
                id: 'arrowCopy',
                type: 'image',
                rect: ['756px', '513px','21px','44px','auto', 'auto'],
                fill: ["rgba(0,0,0,0)",im+"arrow.png",'0px','0px']
            }],
            symbolInstances: [

            ]
        },
    states: {
        "Base State": {
            "${_patch_1}": [
                ["style", "top", '281px'],
                ["style", "opacity", '0'],
                ["style", "left", '800px']
            ],
            "${_taxt_2}": [
                ["style", "top", '600px'],
                ["style", "opacity", '0'],
                ["style", "left", '202px']
            ],
            "${_arrow}": [
                ["style", "top", '301px'],
                ["style", "opacity", '0'],
                ["style", "left", '700px']
            ],
            "${_patch_2}": [
                ["style", "top", '364px'],
                ["style", "opacity", '0'],
                ["style", "left", '750px']
            ],
            "${_patch_text1}": [
                ["style", "top", '388px'],
                ["style", "opacity", '0'],
                ["style", "left", '850px']
            ],
            "${_Stage}": [
                ["color", "background-color", 'rgba(0,0,0,1.00)'],
                ["style", "overflow", 'hidden'],
                ["style", "height", '727px'],
                ["style", "width", '1280px']
            ],
            "${_arrowCopy}": [
                ["style", "top", '382px'],
                ["style", "opacity", '0'],
                ["style", "left", '700px']
            ],
            "${_patch_text}": [
                ["style", "top", '299px'],
                ["style", "opacity", '0'],
                ["style", "left", '850px']
            ],
            "${_taxt_1}": [
                ["style", "top", '99px'],
                ["style", "opacity", '0'],
                ["style", "left", '40px']
            ]
        }
    },
    timelines: {
        "Default Timeline": {
            fromState: "Base State",
            toState: "",
            duration: 1390,
            autoPlay: true,
            timeline: [
                { id: "eid69", tween: [ "style", "${_taxt_1}", "top", '99px', { fromValue: '99px'}], position: 1390, duration: 0 },
                { id: "eid68", tween: [ "style", "${_arrow}", "top", '301px', { fromValue: '301px'}], position: 1390, duration: 0 },
                { id: "eid33", tween: [ "style", "${_patch_text}", "left", '790px', { fromValue: '850px'}], position: 710, duration: 215 },
                { id: "eid26", tween: [ "style", "${_arrow}", "left", '756px', { fromValue: '700px'}], position: 600, duration: 150 },
                { id: "eid45", tween: [ "style", "${_arrowCopy}", "opacity", '1', { fromValue: '0'}], position: 1050, duration: 140 },
                { id: "eid71", tween: [ "style", "${_patch_text}", "top", '299px', { fromValue: '299px'}], position: 1390, duration: 0 },
                { id: "eid3", tween: [ "style", "${_taxt_1}", "opacity", '1', { fromValue: '0'}], position: 65, duration: 185, easing: "easeOutBounce" },
                { id: "eid9", tween: [ "style", "${_taxt_2}", "opacity", '1', { fromValue: '0'}], position: 210, duration: 235 },
                { id: "eid20", tween: [ "style", "${_patch_1}", "left", '715px', { fromValue: '800px'}], position: 405, duration: 240 },
                { id: "eid17", tween: [ "style", "${_patch_1}", "opacity", '1', { fromValue: '0'}], position: 405, duration: 240 },
                { id: "eid74", tween: [ "style", "${_patch_text1}", "top", '388px', { fromValue: '388px'}], position: 1390, duration: 0 },
                { id: "eid70", tween: [ "style", "${_patch_2}", "top", '364px', { fromValue: '364px'}], position: 1390, duration: 0 },
                { id: "eid29", tween: [ "style", "${_patch_text}", "opacity", '1', { fromValue: '0'}], position: 710, duration: 215 },
                { id: "eid53", tween: [ "style", "${_patch_text1}", "left", '790px', { fromValue: '850px'}], position: 1150, duration: 240 },
                { id: "eid73", tween: [ "style", "${_patch_1}", "top", '281px', { fromValue: '281px'}], position: 1390, duration: 0 },
                { id: "eid38", tween: [ "style", "${_patch_2}", "opacity", '1', { fromValue: '0'}], position: 875, duration: 225 },
                { id: "eid46", tween: [ "style", "${_arrowCopy}", "left", '756px', { fromValue: '700px'}], position: 1050, duration: 140 },
                { id: "eid40", tween: [ "style", "${_patch_2}", "left", '715px', { fromValue: '750px'}], position: 875, duration: 225 },
                { id: "eid14", tween: [ "style", "${_taxt_2}", "top", '550px', { fromValue: '600px'}], position: 210, duration: 235 },
                { id: "eid23", tween: [ "style", "${_arrow}", "opacity", '1', { fromValue: '0'}], position: 600, duration: 150 },
                { id: "eid51", tween: [ "style", "${_patch_text1}", "opacity", '1', { fromValue: '0'}], position: 1150, duration: 240 },
                { id: "eid6", tween: [ "style", "${_taxt_1}", "left", '0px', { fromValue: '40px'}], position: 65, duration: 185, easing: "easeOutBounce" },
                { id: "eid72", tween: [ "style", "${_arrowCopy}", "top", '382px', { fromValue: '382px'}], position: 1390, duration: 0 }            ]
        }
    }
}
};


Edge.registerCompositionDefn(compId, symbols, fonts, resources, opts);

/**
 * Adobe Edge DOM Ready Event Handler
 */
$(window).ready(function() {
     Edge.launchComposition(compId);
});
})(jQuery, AdobeEdge, "EDGE-103569781");
